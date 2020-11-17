package com.learning.lambdas;

import com.learning.declarativevsimperative.CalculateFactorial;
import com.learning.util.ProxyCreator;

public class FactorialCalucation implements CalculateFactorial{
public static void main(String[] args) throws Exception{
	
	CalculateFactorial proxy = ProxyCreator.createProxy(FactorialCalucation.class);
	System.out.println(proxy.calculateFactorialRecursively(14
			));
	
	System.out.println(proxy.calculateFactorialUsingTailRecurstion(14,1
			));
}

public  long calculateFactorialRecursively(long number) {
	
	if(number == 0 || number == 1) 
		return 1;
	return number * calculateFactorialRecursively(number-1);
}

//tail recursion to save stack memory
//since one iteration is not holding any variable and hence it is free to remove from stack
public  long calculateFactorialUsingTailRecurstion(long number, long accumulator) {
	if(number == 0 || number == 1) 
		return accumulator;
	
	return calculateFactorialUsingTailRecurstion(number-1, accumulator*number);
}
}
