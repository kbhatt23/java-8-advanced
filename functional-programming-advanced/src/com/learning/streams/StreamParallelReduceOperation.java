package com.learning.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamParallelReduceOperation {
public static void main(String[] args) {
	
	List<String> names=  Arrays.asList("messi","ronaldo","zidane","kaka","xavi","iniesta","puyol","messi","kaka","zidane");
	
	//paralel stream still woprks even when mutaiton happens -> but only local mutation to that pure function
	
	names= names.stream()
		// .parallel()
		 .distinct()
		 .reduce(new ArrayList<String>(), (items,item) ->{
			 items.add(item);
			 return items;
		 }, (items1,items2) -> {items1.addAll(items2);
		 	return items1;
		 });
	
	System.out.println(names);
}
}
