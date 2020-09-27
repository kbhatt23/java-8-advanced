package ownfunctionalInterface;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import common.Student;
import common.StudentDataBase;

public class BiConsumerUsageMap {
	//static BiConsumer<Integer,Integer> additionTwoInteger = (num1,num2) -> System.out.print((num1+num2)+" : ");
	static BiConsumer<Integer,Integer> additionTwoInteger = (num1,num2) -> System.out.print(num1+num2);
	
	static BiConsumer<Integer,Integer> multiplicationTwoInteger = (num1,num2) -> System.out.println(num1*num2);
	public static void main(String[] args) {
		Map<String, List<String>> studentActivityMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.toMap(Student::getName, Student::getActivities));

		studentActivityMap.forEach((name, activities) -> System.out.println(name + " : " + activities));
		
		System.out.println("=============int map bi consumer===");
		Map<Integer, Integer> intMap = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toMap( i -> i, i -> i+1));
		System.out.println(intMap);
		//intMap.forEach(additionTwoInteger.andThen(multiplicationTwoInteger));
		intMap.forEach((a,b) ->{ additionTwoInteger.accept(a, b)
				;System.out.print(" : ");
				multiplicationTwoInteger.accept(a, b);
				}
		);
		
	}
}
