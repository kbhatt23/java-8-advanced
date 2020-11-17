package com.learning.lambdas;

import java.util.Optional;

public class Student {

	private int id;
	
	private String name;
	
	private boolean isFootballFan;
	
	private String email;
	
	private Optional<Vehicle> vehicle;

	public Student(int id, String name, boolean isFootballFan, String email, Vehicle vehicle) {
		super();
		this.id = id;
		this.name = name;
		this.isFootballFan = isFootballFan;
		this.email = email;
		this.vehicle= Optional.ofNullable(vehicle);
	}

	public Optional<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Optional<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFootballFan() {
		return isFootballFan;
	}

	public void setFootballFan(boolean isFootballFan) {
		this.isFootballFan = isFootballFan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", isFootballFan=" + isFootballFan + ", email=" + email + "]";
	}
	
	
}
