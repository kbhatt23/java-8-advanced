package ownfunctionalInterface;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class PredicateUsage {
	static Predicate<Student> higherThanGrage = (student) -> student.getGradeLevel() >= 3;
	static Predicate<Student> higherThanGPA = (student) -> student.getGpa() >= 3.9;
	static Consumer<Student> nameConsumer = (student) -> System.out.println(student.getName());
	static Consumer<Student> printActivities = (student) -> System.out
			.println(student.getActivities().stream().collect(Collectors.joining(",")));

	public static void main(String[] args) {
		StudentDataBase.getAllStudents().forEach(student -> {
			if (higherThanGrage.and(higherThanGPA).test(student)) {
				nameConsumer.accept(student);
			}
		});

		System.out.println("========predicate+consumer===========");
		StudentDataBase.getAllStudents().forEach((student) -> {
			if (higherThanGrage.and(higherThanGPA).test(student)) {
				nameConsumer.andThen(printActivities).accept(student);
			}
		});
	}
}
