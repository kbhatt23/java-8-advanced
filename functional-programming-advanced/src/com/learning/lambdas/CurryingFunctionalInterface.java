package com.learning.lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class CurryingFunctionalInterface {
public static void main(String[] args) {
	Function<Integer, Function<Integer, Integer>> curriedFunction
		= i -> a -> i+a;
		
		System.out.println(curriedFunction.apply(23).apply(32));
}
}
