package com.rohit.springboot.rsocket.controller;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.rohit.springboot.rsocket.model.Claim;
import com.rohit.springboot.rsocket.model.ClinicalData;
import com.rohit.springboot.rsocket.model.Patient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class RSocketPatientController {
	
	Logger logger = LoggerFactory.getLogger(RSocketPatientController.class);
	
	@MessageMapping("get-patient-data")
	public Mono<ClinicalData> requestResponse(@RequestBody Patient patient){
		logger.info("Received Patient: "+patient);
		return Mono.just(new ClinicalData(90, "80/120"));
	}
	
	@MessageMapping("patient-checkout")
	public Mono<Void> fireAndForget(Patient patient) {
		logger.info("Patient checking out : "+patient);
		logger.info("Billing initiated");
		return Mono.empty().then();
	}
	
	@MessageMapping("claim-stream")
	public Flux<Claim> requestStream() {
		return Flux.just(new Claim(1000f, "MRI Scan"),new Claim(2000f, "Surgery"),new Claim(5000f, "Food")).delayElements(Duration.ofSeconds(2));
	}

}
