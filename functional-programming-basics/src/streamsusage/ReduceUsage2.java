package streamsusage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class ReduceUsage2 {
public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(3,4,5,6,2,25,2,3,52,2);
	
	//int sum = numbers.stream().mapToInt(Integer::intValue).sum();
	//below is better as intValue is int primtive and intfunction needs to auto cast it to Integer
	//value of returns Integer itseld
	int sum = numbers.stream().mapToInt(Integer::valueOf).sum();
	System.out.println(sum);
	//Integer reduceSum = numbers.stream().reduce( Integer::sum).orElse(0);
	Integer reduceSum = numbers.stream().reduce(0, Integer::sum);
	System.out.println(reduceSum);
	
	Optional<Integer> reduceSumWithoutIdentity = numbers.stream().reduce( Integer::sum);
	//below is better to save unbozing and autoboxing while doing manipulation
	OptionalInt reduceSumWithoutIdentity1 = numbers.stream().mapToInt(Integer::valueOf).reduce( Integer::sum);
	System.out.println(reduceSumWithoutIdentity1.getAsInt() == reduceSumWithoutIdentity.get());
	
	//multiplication
	int reduceMultiply = numbers.stream().mapToInt(Integer::valueOf).reduce(1, (a,b) -> a*b);
	
	System.out.println(reduceMultiply);
	int multiply=1;
	for(int a : numbers) {
		multiply*=a;
	}
	System.out.println(multiply);
	
	List<Integer> emptyNumbers = Arrays.asList();
	Optional<Integer> optionInteger = emptyNumbers.stream().reduce(Integer::sum);
	
	//optionsl.of will give exeption when used with null while creating optional object itlsef
	//optiona,.ofnullanble can push null
	//such case ispresent is false and .get will give runime exception
	System.out.println(optionInteger.isPresent());
	if(optionInteger.isPresent()) {
		System.out.println(optionInteger.get());
	}
	
}
}
