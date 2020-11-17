package com.learning.lambdas;

import java.util.function.Function;

public class LazyLoadingOrder {

	private String id;
	
	private String name;
	
	private String address;
	
	private double price;
	
	
	private static Function<LazyLoadingOrder, LazyLoadingOrder> lazyFunction ;


	public String getId() {
		return id;
	}


	public static void setId(String id) {
		lazyFunction = order -> {order.id=id; return order;};
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public static LazyLoadingOrder build() {
		return lazyFunction.apply(new LazyLoadingOrder());
	}
	
			
}
