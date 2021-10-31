package com.rohit.springboot.reactive;

import java.util.function.Consumer;

import com.rohit.springboot.reactive.vaccine.Vaccine;

public class VaccineComsumer implements Consumer<Vaccine> {

	@Override
	public void accept(Vaccine vaccine) {
		System.out.println(vaccine.getName());
		System.out.println(vaccine.isDeliverd());
	}

}
