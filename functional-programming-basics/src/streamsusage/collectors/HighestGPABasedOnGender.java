package streamsusage.collectors;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class HighestGPABasedOnGender {
public static void main(String[] args) {
	Map<String, Optional<Student>> byGenderOptional = StudentDataBase.getAllStudents().stream()
		.collect(Collectors.groupingBy(Student::getGender, 
				
				Collectors.maxBy(Comparator.comparing(Student::getGpa))));
	System.out.println(byGenderOptional);
	
	Map<String, Student> byGender = StudentDataBase.getAllStudents().stream()
			.collect(Collectors.groupingBy(Student::getGender, 
					Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa) 
							
							)
							, Optional::get
					)));
	System.out.println(byGender);
	
	Map<String, String> byGenderNAmeOnly = StudentDataBase.getAllStudents().stream()
			.collect(Collectors.groupingBy(Student::getGender, 
					Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa) 
							
							)
							, a -> a.get().getName()
					)));
	
	System.out.println(byGenderNAmeOnly);
}
}
