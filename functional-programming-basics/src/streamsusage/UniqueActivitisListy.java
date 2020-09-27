package streamsusage;

import java.util.List;
import java.util.stream.Collectors;

import common.StudentDataBase;

public class UniqueActivitisListy {
public static void main(String[] args) {
	List<String> collect = StudentDataBase.getAllStudents().stream()
			.flatMap(s -> s.getActivities().stream())
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	System.out.println(collect);
	
	System.out.println(StudentDataBase.getAllStudents().stream()
			.flatMap(s -> s.getActivities().stream())
			.distinct()
			.sorted().count());
}
}
