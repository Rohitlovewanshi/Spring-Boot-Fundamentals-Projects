package com.rohit.springboot.reactive;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rohit.springboot.reactive.vaccine.Vaccine;
import com.rohit.springboot.reactive.vaccine.VaccineProvider;
import com.rohit.springboot.reactive.vaccine.VaccineService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class VaccineProviderTest {

	@Autowired
	VaccineProvider provider;

	@MockBean
	VaccineService service;

	@Test
	void testVaccineProvider_reactive() {
		when(service.getVaccines()).thenReturn(Flux.just(new Vaccine("Rohit"), new Vaccine("J&J"), new Vaccine("Covaxin")));
		StepVerifier.create(provider.provideVaccines())
		.expectSubscription()
		.expectNext(new Vaccine("Rohit"))
		.expectNext(new Vaccine("J&J"))
		.expectNext(new Vaccine("Covaxin"))
		.expectComplete().verify();
	}

}
