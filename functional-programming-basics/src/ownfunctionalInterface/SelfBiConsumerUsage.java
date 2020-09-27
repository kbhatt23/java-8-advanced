package ownfunctionalInterface;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import common.Student;
import common.StudentDataBase;

public class SelfBiConsumerUsage {
	static SelfBiConsumer<String, List<String>> nameAndActivityBiConsumer = (studentName, studentActivities) -> System.out
			.print(studentName + " : " + studentActivities + "\n");

	static SelfBiConsumer<String, List<String>> nameAndActivityBiConsumerCopy = (studentName,
			studentActivities) -> System.out.print(studentName + " : " + studentActivities + "\n");
	static SelfBiConsumer<String, List<String>> combined = nameAndActivityBiConsumer.andThen(nameAndActivityBiConsumerCopy);
	
	static SelfBiConsumer<Integer,Integer> additionTwoInteger = (num1,num2) -> System.out.println(num1+num2);
	
	static SelfBiConsumer<Integer,Integer> multiplicationTwoInteger = (num1,num2) -> System.out.println(num1*num2);

	public static void main(String[] args) {

		Student firstStudent = StudentDataBase.getAllStudents().get(0);
		nameAndActivityBiConsumer.accept(firstStudent.getName(), firstStudent.getActivities());
		System.out.println("=====================");

		combined.accept(firstStudent.getName(), firstStudent.getActivities());

		System.out.println("comlex========================");

		StudentDataBase.getAllStudents()
				.forEach((student) -> combined.accept(student.getName(), student.getActivities()));
		System.out.println("===============integer maniplation=============");
		additionTwoInteger.andThen(multiplicationTwoInteger).accept(10, 11);

	}
}
