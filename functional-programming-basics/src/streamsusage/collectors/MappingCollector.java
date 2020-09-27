package streamsusage.collectors;

import java.util.List;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class MappingCollector {
public static void main(String[] args) {
	List<String> allNames1=
	StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.mapping(Student::getName, Collectors.toList()));
	
	//System.out.println(allNames1);
	
	List<String> allNames2= StudentDataBase.getAllStudents()
	.stream()
		.map(Student::getName)
		.collect(Collectors.toList());
	System.out.println(allNames2);
	System.out.println(allNames1);
}
}
