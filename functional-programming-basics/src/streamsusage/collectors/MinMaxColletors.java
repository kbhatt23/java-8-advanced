package streamsusage.collectors;

import java.util.Comparator;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class MinMaxColletors {
public static void main(String[] args) {
	Student maxGPAStudent =StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)))
//		.orElseThrow(RuntimeException::new);
		.orElse(null);
	System.out.println(maxGPAStudent);
	
	//only name
	
	String maxGPAStudentName =StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)))
			.map(Student::getName)
			.orElse("no student found")
			;
	System.out.println(maxGPAStudentName);
	
	Student minGPAStudent =StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)))
//			.orElseThrow(RuntimeException::new);
			.orElse(null);
		System.out.println(minGPAStudent);
		
		//only name
		
		String minGPAStudentName =StudentDataBase.getAllStudents()
				.stream()
				//.filter(s -> s.getGpa()>4)
				.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)))
				.map(Student::getName)
				.orElse("no student found")
				;
		System.out.println(minGPAStudentName);
}
}
