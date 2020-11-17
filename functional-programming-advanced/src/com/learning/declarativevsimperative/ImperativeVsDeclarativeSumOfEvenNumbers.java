package com.learning.declarativevsimperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.learning.util.ProxyCreator;

public class ImperativeVsDeclarativeSumOfEvenNumbers implements ProxyCapable{
public static void main(String[] args) {
	ProxyCapable createProxy = null;
	try {
		 createProxy = ProxyCreator.createProxy(ImperativeVsDeclarativeSumOfEvenNumbers.class);
	} catch (Exception e) {
		e.printStackTrace();
	}
	if(createProxy != null) {
		createProxy.usingImperative();
		createProxy.usingDeclarative();
	}
	
}



public  void usingImperative() {
	
	List<Integer> findNumbersImperatively = findNumbersImperatively(100);
	//System.out.println(findNumbersImperatively);
	int sumOfEvenImperative = 0;
	for(int number:findNumbersImperatively) {
		if(number % 2 == 0)
			sumOfEvenImperative+=number;
	}
	System.out.println("sum imperative "+sumOfEvenImperative);
}

//imperative get all numbers
private  static List<Integer> findNumbersImperatively(int size){
	//we know the actual size and hence creating internal array of same size , so tha no need of increasing size of array
	List<Integer> numbers  =new ArrayList<Integer>(size);
	//for(int i=0 ; i < size; i++) {
		//numbers.add(i+1);
	//}
	
	for(int i=1 ; i <= size; i++) {
		numbers.add(i);
	}
	return numbers;
}

public  void usingDeclarative() {
	List<Integer> findNumbersDeclaratively = findNumbersDeclaratively(100);
	System.out.println(findNumbersDeclaratively);
	
	System.out.println("sum using declarative "+findNumbersDeclaratively.stream()
			.filter(i -> i%2 == 0)
			.mapToInt(Integer::intValue)
			.sum());
	
		/*
		 * System.out.println("using reduce "+ findNumbersDeclaratively.stream()
		 * .parallel() .filter(i -> i%2 == 0) .reduce(0, Integer::sum ));
		 */
}

//imperative get all numbers
private  List<Integer> findNumbersDeclaratively(int size){
	return IntStream.rangeClosed(1, size)
			.parallel()
			.boxed()
			.collect(Collectors.toList());
}
}
