package streamsusage;

import java.util.Comparator;
import java.util.OptionalDouble;

import common.Student;
import common.StudentDataBase;

public class ReduceBasic {
public static void main(String[] args) {
	//finding the student with maximum gpa
	
	Student maxGPAStudent = StudentDataBase.getAllStudents().stream()
		.reduce((s1,s2) -> s1.getGpa() >= s2.getGpa() ? s1: s2)
		.orElse(null)
		;
	System.out.println(maxGPAStudent);
	
	double maxGPA = StudentDataBase.getAllStudents().stream()
			.map(Student::getGpa)
			.reduce((s1,s2) -> s1 >= s2 ? s1: s2)
			.orElse(0d)
			;
	System.out.println(maxGPA);
	
	double minGPA = StudentDataBase.getAllStudents().stream()
			.map(Student::getGpa)
			.reduce(Double.MAX_VALUE,(s1,s2) -> s1 <= s2 ? s1: s2)
			//.orElse(0d)
			;
	System.out.println(minGPA);
	
	maxGPAStudent =StudentDataBase.getAllStudents().stream()
			.max(Comparator.comparing(Student::getGpa))
			.orElse(null)
			;
	System.out.println(maxGPAStudent);
	
	//sum of all student's gpa
	double reduce = StudentDataBase.getAllStudents().stream()
	.map(Student::getGpa)
	.reduce(0d, (s1,s2) -> s1+s2);
	
	System.out.println(reduce);
	
	OptionalDouble average = StudentDataBase.getAllStudents().stream()
	.mapToDouble(Student::getGpa).average();
	System.out.println(average);
	System.out.println("complex average "+reduce/StudentDataBase.getAllStudents().size());
}
}
