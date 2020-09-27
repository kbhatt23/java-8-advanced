package streamsusage.collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import common.Student;
import common.StudentDataBase;
import common.StudentsPRedicates;

public class JoiningCollectorUsage {
public static void main(String[] args) {
	String femaleNames= 
	StudentDataBase.getAllStudents().stream()
		.filter(StudentsPRedicates.IS_FEMALE_STUDENT)
		.map(Student::getName)
			.collect(Collectors.joining(","));
	System.out.println(femaleNames);
	System.out.println("==========");
	String allNames= 
	StudentDataBase.getAllStudents().stream()
		.map(Student::getGpa)
		.map(String::valueOf)
			.collect(Collectors.joining(","));
	System.out.println(allNames);
} 

}
