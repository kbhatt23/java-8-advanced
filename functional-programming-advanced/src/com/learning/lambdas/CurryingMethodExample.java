package com.learning.lambdas;

import java.util.Arrays;

public class CurryingMethodExample {
public static void main(String[] args) {
		System.out.println(sum(10, sum(20, 30)));
		
		System.out.println(sumCalculatorRecursively(1,2,4,1,1,1,1,1,1,1,1));
	}

public static int sum(int a,int b) {
	return a+b;
}

public static int sumCalculatorRecursively(int... numbers) {
	//when none args are passed , array size will be 0,
	if(numbers == null || numbers.length == 0) {
		return 0;
	}
	if(numbers.length == 1) {
		return numbers[0];
	}
	
	if(numbers.length == 2) {
		return numbers[0] + numbers[1];
	}
	int[] numbersWithoutFirstIndex = Arrays.copyOfRange(numbers, 1, numbers.length);
	return numbers[0] + sumCalculatorRecursively(numbersWithoutFirstIndex);
}
}
