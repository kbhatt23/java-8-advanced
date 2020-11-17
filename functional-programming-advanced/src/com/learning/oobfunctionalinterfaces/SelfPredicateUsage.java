package com.learning.oobfunctionalinterfaces;

public class SelfPredicateUsage {
public static void main(String[] args) {
	SelfPredicate<String> integerStringTest = str -> {
		System.out.println("checking string "+str+ " if number");
		boolean isInteger = true;
		for(char c : str.toCharArray()) {
			if(!Character.isDigit(c)) {
				isInteger=false;
				break;
			}
		}
		return isInteger;
	};
	
	validatePRedicate(integerStringTest);
	System.out.println("============");
	//chaingin methods
	SelfPredicate<String> greaterThan20 = str ->{ 	System.out.println("checking string "+str+ " if greater than 20"); 
	boolean isGreaterthan20 = false;
	try {
		isGreaterthan20 = Integer.parseInt(str) > 20 ;}
	catch (Exception e) {
	}
	return isGreaterthan20;
	};
	
	validateChainingMethods(integerStringTest, greaterThan20);
}

private static void validateChainingMethods(SelfPredicate<String> one , SelfPredicate<String> two) {
	//System.out.println("final result "+one.and(two).test("jai shree ram"));
	
	//System.out.println("final result "+one.and(two).test("23"));
	
	//System.out.println("final result "+one.and(two).test("20"));
	
	//System.out.println("final result "+one.or(two).test("jai shree ram"));
	
	//System.out.println("final result "+one.or(two).test("23"));
	
	//System.out.println("final result "+one.or(two).test("20"));
	
	System.out.println("final result "+one.not().test("jai shree ram")); // true
	
	System.out.println("final result "+one.not().test("20")); // false
	
	System.out.println("final result "+one.not().test("23")); // flase
	
System.out.println("final result "+two.not().test("jai shree ram"));  // true
	
	System.out.println("final result "+two.not().test("20")); // true
	
	System.out.println("final result "+two.not().test("23")); // false
	
}

private static void validatePRedicate(SelfPredicate<String> integerStringTest) {
	String str1 = "jai shree ram";
	System.out.println("test for str "+str1+" is: "+integerStringTest.test(str1));
	
	String str2 = "23.23";
	System.out.println("test for str "+str2+" is: "+integerStringTest.test(str2));
	
	
	String str3 = "23";
	System.out.println("test for str "+str3+" is: "+integerStringTest.test(str3));
}
}
