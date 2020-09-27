package ownfunctionalInterface;

import java.util.function.Function;

import common.StudentDataBase;

public class FunctionUsage {
	static Function<String, String> upperCase = a -> a.toUpperCase();
	
	static Function<String, String> studentAppend = a -> "student name : "+a ;

	public static void main(String[] args) {
		Function<String, String> f1 = str -> str.split(" ")[0];

		Function<String, Integer> f2 = str -> str.length();

		System.out.println(f1.andThen(f2).apply("jai shree ram"));

		System.out.println(f2.compose(f1).apply("jai shree ram"));

		System.out.println("students usage=============");

		StudentDataBase.getAllStudents().forEach(student -> System.out.println(upperCase.andThen(studentAppend).apply(student.getName())));
		System.out.println("==============compose===========");
		StudentDataBase.getAllStudents().forEach(student -> System.out.println(upperCase.compose(studentAppend).apply(student.getName())));
		
	}
}
