package com.learning.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterMapReduceLambdaTransfomation {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("", "jai shree ram", "jai radha madhav", "jai uma shankar",
				"jai ramaduta hanuman","fake kingla", "lapa","lakshmi narayan ki jai"
				);
		 Function<String, String> transformation = String::toUpperCase;
		 Predicate<String> filter1 = str -> str.contains("jai");
		 Predicate<String> filter2 = str -> str.contains("radha");
		 Predicate<String> filter3 = str -> str.contains("lakshmi");
		 Predicate<String> filter = filter1.and(filter2.or(filter3));
		 Consumer<String> printStatement = str -> System.out.println("checking if string "+str + " contatins jai radha/lakshmi");
	
		 List<String> transformFilterTogether = transformFilterTogether(input, transformation, filter, printStatement);
		 System.out.println(transformFilterTogether);
	}
	
	public static <T,R> List<R> transformFilterTogether(List<T> input, Function<T, R> transformation, Predicate<T> filter,
			Consumer<T> printStatement
			){
		
		List<R> transformedList = new ArrayList<>();
		for(T item: input) {
			//print statment for each item
			printStatement.accept(item);
			if(filter.test(item)) {
				transformedList.add(transformation.apply(item));	
			}
		}
		
		return transformedList;
	}
}
