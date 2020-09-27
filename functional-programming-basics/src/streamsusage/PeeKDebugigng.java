package streamsusage;

import java.util.List;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class PeeKDebugigng {
	public static void main(String[] args) {
		List<Student> goodStudents = StudentDataBase.getAllStudents().stream()
				.peek(s -> System.out.println("inital student to process " + s.getName()))
				.filter(Student::isExcellentStudent)
				.peek(s -> System.out.println("student after filtering " + s.getName()))
				.collect(Collectors.toList());
		
		goodStudents.forEach(System.out::println);
	}
}
