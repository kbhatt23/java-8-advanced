package com.learning.lambdas;

public class Vehicle {

	private String type;
	
	private String number;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Vehicle(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", number=" + number + "]";
	}
	
	
	
	
}
