package com.rohit.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rohit.core.services.PaymentService;
import com.rohit.core.services.PaymentServiceImpl;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	PaymentServiceImpl service;
	
	@Test
	void tesDependecyInjection() {
		Assertions.assertNotNull(service.getDao());
	}

}
