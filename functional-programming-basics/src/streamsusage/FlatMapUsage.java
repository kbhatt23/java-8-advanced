package streamsusage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class FlatMapUsage {
public static void main(String[] args) {
	//if we have stream of stream as input and want stram of object
	//or we have stream of array or stream of list and we want stream of object
	
	List<String> allACtivitiesList = StudentDataBase.getAllStudents()
			.stream()
			.map(Student::getActivities) // Stream<List<String>>
			.flatMap(List::stream) // Stream of string, basically skips groupoing and clubs together all activities
			.distinct()
			//.forEach(System.out::println);
			.collect(Collectors.toList());
	System.out.println(allACtivitiesList);
	System.out.println("===================");
	
	List<String> allFootballers = StudentDataBase.getAllStudents()
	.stream()
	//.flatMap(s -> Arrays.stream(s.getFavouriteFootballers()))
	.map(Student::getFavouriteFootballers)
	.flatMap(Arrays::stream)
	//.flatMap(s -> Arrays.stream(s))
			.distinct()
			.collect(Collectors.toList());
	System.out.println(allFootballers);
	
	System.out.println("============");
	StudentDataBase.getAllStudents()
	.stream()
	//.flatMap(s -> Arrays.stream(s.getFavouriteFootballers()))
	.map(Student::getActivities)
	.forEach(System.out::println);
}
}
