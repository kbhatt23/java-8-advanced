package streamsusage.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class GroupByType1 {
public static void main(String[] args) {
	Map<String, List<Student>> groupByGender
		= StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGender));
	groupByGender.forEach((k,v) -> System.out.println(k+" : "+v));

	//based on custom string categoriztion
	
	Map<String, List<Student>> groupByOutstandingOrAvgStudent
	
		=StudentDataBase.getAllStudents().stream()
		.collect(Collectors.groupingBy(s -> s.getGpa() >= 3.9 ? "excellent": "average"));
	
	groupByOutstandingOrAvgStudent.forEach((k,v) -> System.out.println(k+" : "+v));

}
}
