package com.rohit.springboot.reactive;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rohit.springboot.reactive.vaccine.Vaccine;
import com.rohit.springboot.reactive.vaccine.VaccineProvider;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class ReactiveDemoApplicationTests {

	@Autowired
	VaccineProvider provider;

	@Test
	void testVaccineProvider_reactive() {
		StepVerifier.create(provider.provideVaccines()).expectSubscription().expectNext(new Vaccine("Pfizer"))
				.expectNext(new Vaccine("J&J")).expectNext(new Vaccine("Covaxin")).expectComplete().verify();
	}

	@Test
	void testVaccineProvider_reactive_assertThat() {
		StepVerifier.create(provider.provideVaccines()).expectSubscription().assertNext(vaccine -> {
			assertThat(vaccine.getName()).isNotNull();
			Assertions.assertTrue(vaccine.isDeliverd());
			Assertions.assertEquals("Pfizer", vaccine.getName());
		})
		.thenConsumeWhile(vaccine->{
			return true;
		})
		.expectNext(new Vaccine("J&J")).expectNext(new Vaccine("Covaxin")).expectComplete().verify();
	}

	@Test
	void testVaccineProvider_reactive_expectNextCount() {
		StepVerifier.create(provider.provideVaccines()).expectSubscription().expectNextCount(3).expectComplete()
				.verify();
	}

	@Test
	void testVaccineProvider() {
		provider.provideVaccines().subscribe(new VaccineComsumer());
	}

	@Test
	void testMono() {
		Mono<String> mono = Mono.just("Macbook M1 Pro");
		mono.log().map(data -> data.toUpperCase()).subscribe(System.out::println);
	}

	@Test
	void testFlux() throws InterruptedException {
		Flux.fromIterable(Arrays.asList("Macbook M1 Pro", "Iphone", "Dell")).delayElements(Duration.ofSeconds(2)).log()
				.map(data -> data.toUpperCase()).subscribe(new Subscriber<String>() {

					@Override
					public void onSubscribe(Subscription subscription) {
						subscription.request(Long.MAX_VALUE);
					}

					@Override
					public void onNext(String order) {
						System.out.println(order);
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
					}

					@Override
					public void onComplete() {
						System.out.println("Completely done");
					}

				});

		Thread.sleep(6000);
	}

}
