package com.learning.oobfunctionalinterfaces;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorUsage {
	public static void main(String[] args) {
		BiFunction<String, Integer, String> biFunction = (s, number) -> s + " : " + number;

		System.out.println(biFunction.apply("jai shree ram", 108));

		BinaryOperator<String> operatorCombined = (str1, str2) -> str1 + " : " + str2;

		System.out.println(operatorCombined.apply("jai shree ram", "jai radhe krishna"));
		int a = 1;
		int b=-13;
		Comparator<Integer> c = Comparator.comparing(Function.identity());
		System.out.println(BinaryOperator.maxBy(c).apply(a, b));
	
	}

}
