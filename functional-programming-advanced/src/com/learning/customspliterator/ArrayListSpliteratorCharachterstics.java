package com.learning.customspliterator;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class ArrayListSpliteratorCharachterstics {
public static void main(String[] args) {
	List<String> names = Arrays.asList("sita-ram","radhe-krishna", "lakshmi-narayan","uma-maheshwar");
	Spliterator<String> spliterator = names.stream().spliterator();
	System.out.println("chekcing spliterator for arraylist");
	
	analyzeSpliteratorCharachterstics(spliterator);
	System.out.println("===========================");
	
	System.out.println("chekcing spliterator for hashet");
	analyzeSpliteratorCharachterstics(names.stream()
		.collect(Collectors.toSet())
		.stream().spliterator());
	System.out.println("===========================");
}

public static void analyzeSpliteratorCharachterstics(Spliterator<String> spliterator) {

	System.out.println("sorted charachterstics: "+spliterator.hasCharacteristics(Spliterator.SORTED));
	
	System.out.println("ordered charachterstics: "+spliterator.hasCharacteristics(Spliterator.ORDERED));
	System.out.println("sized charachterstics: "+spliterator.hasCharacteristics(Spliterator.SIZED));
	System.out.println("distinct charachterstics: "+spliterator.hasCharacteristics(Spliterator.DISTINCT));
	System.out.println("concurrent charachterstics: "+spliterator.hasCharacteristics(Spliterator.CONCURRENT));
}
}
