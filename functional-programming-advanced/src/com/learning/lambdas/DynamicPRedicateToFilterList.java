package com.learning.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DynamicPRedicateToFilterList {
public static void main(String[] args) {
	List<String> names = Arrays.asList("", "jai shree ram", "jai radha madhav", "jai uma shankar",
			"jai ramaduta hanuman","fake kingla", "lapa","lakshmi narayan ki jai"
			);
			
	Predicate<String> predicate1 = name -> name.contains("jai");
	Predicate<String> predicate2 = name -> name.contains("radha");
	Predicate<String> predicate3 = name -> name.contains("lakshmi");
	System.out.println(filterFlexibleWay(names, predicate1.and(predicate2).or(predicate3)));
}

public static List<String> filterFlexibleWay(List<String> names, Predicate<String> predicate){
	List<String> filteredList  = new ArrayList<String>();
	for(String name:names) {
		if(predicate.test(name)) {
			filteredList.add(name);
		}
	}
	return filteredList;
}
}
