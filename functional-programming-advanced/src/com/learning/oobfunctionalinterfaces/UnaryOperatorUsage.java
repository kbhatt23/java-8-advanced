package com.learning.oobfunctionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class UnaryOperatorUsage {
public static void main(String[] args) {
	UnaryOperator<String> operator = str -> str.toUpperCase();
	
	UnaryOperator<String> operator1 = String::toUpperCase;
	String str  = "jai shree ram";
	System.out.println("first operation "+operator.apply(str));
	
	System.out.println("second operation "+operator1.apply(str));
	
}
}
