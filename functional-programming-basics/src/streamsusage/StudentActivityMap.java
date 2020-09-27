package streamsusage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;
import common.StudentsPRedicates;

public class StudentActivityMap {
public static void main(String[] args) {
	Map<String, List<String>> studentActivityMap = StudentDataBase.getAllStudents().stream().collect(Collectors.toMap(Student::getName, Student::getActivities));

	printMap(studentActivityMap);
	
	System.out.println("========================");
	
	Map<String, List<String>> excellentstudentActivityMap = StudentDataBase.getAllStudents().stream().
			filter(Student::isExcellentStudent)
			.collect(Collectors.toMap(Student::getName, Student::getActivities));

	printMap(excellentstudentActivityMap);
	System.out.println("=================");
	Map<String, List<String>> excellentstudentActivityMap1 = StudentDataBase.getAllStudents().stream().
			//filter(StudentsPRedicates.IS_GRADE_GREATER_THAN_THREE)
			filter(StudentsPRedicates::isStudentGreaterThanThree)
			.collect(Collectors.toMap(Student::getName, Student::getActivities));

	printMap(excellentstudentActivityMap1);
}

public static void printMap(Map<String, List<String>> studentMap) {
	studentMap.forEach((k,v) -> System.out.println(k+" : "+v));
}
}
