package ownfunctionalInterface;

import java.util.function.Consumer;

import common.Student;
import common.StudentDataBase;

public class ConsumerStudentUSage {
	static Consumer<Student> printName = (student) -> System.out.print(student.getName() + " : ");

	static Consumer<Student> printActivities = (student) -> System.out.println(student.getActivities());

	static Consumer<Student> nameandActivites = printName.andThen(printActivities);

	public static void main(String[] args) {

		nameandActivites.accept(StudentDataBase.getAllStudents().get(0));

		// for each
		// one by one for each item(student) it calls accpt method of consumer
		StudentDataBase.getAllStudents().forEach(nameandActivites);
		System.out.println("==================");
		// cusotm consumer runtime
		StudentDataBase.getAllStudents().forEach((student) -> {
		//	System.out.println("validating student " + student.getName());
			if (student.getGpa() >= 3.9 && student.getGradeLevel() >= 3) {
				nameandActivites.accept(student);
			}
		});
	}
}
