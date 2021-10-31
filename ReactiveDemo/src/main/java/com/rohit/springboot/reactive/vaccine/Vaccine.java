package com.rohit.springboot.reactive.vaccine;

public class Vaccine {

	private String name;
	private boolean deliverd;

	public Vaccine(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeliverd() {
		return deliverd;
	}

	public void setDeliverd(boolean deliverd) {
		this.deliverd = deliverd;
	}

	@Override
	public String toString() {
		return "Vaccine [name=" + name + ", deliverd=" + deliverd + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Vaccine vaccine = null;
		if(obj instanceof Vaccine) {
			vaccine = (Vaccine) obj;
		}
		return this.name.equals(vaccine.name);
	}

}
