package streamsusage.collectors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class GroupBytype3 {
public static void main(String[] args) {
	//default it gives hashmpa whihc is random in iteration
	Map<String,Integer> nameNoteBooks = StudentDataBase.getAllStudents().stream()
		.collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getNoteBooks)));
	
	nameNoteBooks.forEach((k,v) -> System.out.println(k+" : "+v));
	
	Map<String,Integer> nameNoteBooksOrdered = StudentDataBase.getAllStudents().stream()
			.collect(Collectors.groupingBy(Student::getName,LinkedHashMap::new ,Collectors.summingInt(Student::getNoteBooks)));
		
		System.out.println("=============");
		nameNoteBooksOrdered.forEach((k,v) -> System.out.println(k+" : "+v));
		
}
}
