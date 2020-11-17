package com.learning.lambdas;

public class LambdaWay {
	public static void main(String[] args) {
		MyFunctionalInterface type1 = () -> System.out.println("jai shree ram");

		type1.apply();
		
		MyFunctionalInterface type2 = () -> System.out.println("jai radhe krishna");

		type2.apply();
	}
}
