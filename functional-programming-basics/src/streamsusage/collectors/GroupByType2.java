package streamsusage.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class GroupByType2 {
public static void main(String[] args) {
	Map<String, Long> genderCount =StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
	System.out.println(genderCount);
	
	
	
	Map<String, Long>  exceleneeGrouping= StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(student -> student.getGpa() >= 3.9 ? "excellent": "average",
					Collectors.counting()
					)
					);
	
	System.out.println(exceleneeGrouping);
	
	//names based on groups
	
	Map<String, List<String>> genderBasedNames =StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGender, Collectors.mapping(Student::getName, Collectors.toList())));
		System.out.println(genderBasedNames);
		
		
		
		Map<String, List<String>>  exceleneeGroupingNAmes= StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(student -> student.getGpa() >= 3.9 ? "excellent": "average",
						Collectors.mapping(Student::getName, Collectors.toList())
						)
						);
		System.out.println(exceleneeGroupingNAmes);
	
	
}
}
