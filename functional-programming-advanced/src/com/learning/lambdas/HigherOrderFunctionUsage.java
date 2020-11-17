package com.learning.lambdas;

import java.util.function.Function;
import java.util.function.Supplier;

public class HigherOrderFunctionUsage {
	public static void main(String[] args) {
		System.out.println(createAndManipulate(Math::random, String::valueOf).get());
	}
	
	public static <T,R> Supplier<R> createAndManipulate(Supplier<T> producer, Function<T, R> transformer){
		
		return () -> transformer.apply(producer.get());
	}
}
