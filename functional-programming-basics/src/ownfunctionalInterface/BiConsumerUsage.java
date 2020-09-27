package ownfunctionalInterface;

import java.util.List;
import java.util.function.BiConsumer;

import common.Student;
import common.StudentDataBase;

public class BiConsumerUsage {
	static BiConsumer<String, List<String>> nameAndActivityBiConsumer = (studentName, studentActivities) -> System.out
			.print(studentName + " : " + studentActivities + "\n");

	static BiConsumer<String, List<String>> nameAndActivityBiConsumerCopy = (studentName,
			studentActivities) -> System.out.print(studentName + " : " + studentActivities + "\n");
	static BiConsumer<String, List<String>> combined = nameAndActivityBiConsumer.andThen(nameAndActivityBiConsumerCopy);

	public static void main(String[] args) {

		Student firstStudent = StudentDataBase.getAllStudents().get(0);
		nameAndActivityBiConsumer.accept(firstStudent.getName(), firstStudent.getActivities());
		System.out.println("=====================");

		combined.accept(firstStudent.getName(), firstStudent.getActivities());

		System.out.println("comlex========================");

		 StudentDataBase.getAllStudents()
				.forEach((student) -> combined.accept(student.getName(), student.getActivities()));

	}
}
