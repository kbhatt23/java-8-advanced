package com.learning.oobfunctionalinterfaces;

import java.util.function.ToIntFunction;

public class SelfFunctionUSage {
public static void main(String[] args) {
	SelfFunction<String, Integer> strToNumber = str -> str.length();
	
	//ToIntFunction<String> strToNumber1 = str -> str.length();
	
	System.out.println("strToNumber "+strToNumber.apply("jai shree ram"));
	
	//chaining 
	SelfFunction<Integer, Integer> addIntchars = number -> {
		int sum = 0;
		while(number % 10 != 0) {
			sum+=number%10;
			number = number/10;
		}
		return sum;
	};
	
	System.out.println("chainign sum result "+strToNumber.andThen(addIntchars).apply("jai shree ram"));
	
	System.out.println("compose usage");
	
	System.out.println(addIntchars.compose(strToNumber).apply("jai shree ram"));
	
} 

}
