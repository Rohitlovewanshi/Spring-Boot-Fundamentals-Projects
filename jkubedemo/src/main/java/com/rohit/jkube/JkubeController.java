package com.rohit.jkube;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JkubeController {

	@GetMapping
	public String hello() {
		return "Jkube is cool!";
	}
}
