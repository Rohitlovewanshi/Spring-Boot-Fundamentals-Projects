package com.rohit.springboot.reactive.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class VaccineController {
	
	@Autowired
	VaccineService service;
	
	@GetMapping("/vaccines")
	public Flux<Vaccine> getVaccines() {
		return service.getVaccines();
	}

}
