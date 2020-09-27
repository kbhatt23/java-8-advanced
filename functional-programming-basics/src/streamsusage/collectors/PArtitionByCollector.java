package streamsusage.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import common.StudentDataBase;
import common.Student;

public class PArtitionByCollector {
public static void main(String[] args) {
	Map<Boolean, List<Student>> goodPAritionStudent=
	StudentDataBase.getAllStudents().stream()
		.collect(Collectors.partitioningBy(s -> s.getGpa() >= 3.9));
	
	goodPAritionStudent.forEach((k,v) -> System.out.println(k+" : "+v));
	
	Map<Boolean, List<String>> goodPAritionStudentNAmes=
			StudentDataBase.getAllStudents().stream()
				.collect(Collectors.partitioningBy(s -> s.getGpa() >= 3.9 , Collectors.mapping(Student::getName, Collectors.toList())));

	goodPAritionStudentNAmes.forEach((k,v) -> System.out.println(k+" : "+v));
	
	
	Map<Boolean, String> goodPAritionStudentBestStudent=
			StudentDataBase.getAllStudents().stream()
				.collect(Collectors.partitioningBy(s -> s.getGpa() >= 3.9 , Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), s -> s.get().getName())));

	goodPAritionStudentBestStudent.forEach((k,v) -> System.out.println(k+" : "+v));
	
	
}
}
