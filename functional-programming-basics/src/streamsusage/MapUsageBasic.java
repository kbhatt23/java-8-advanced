package streamsusage;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class MapUsageBasic {
	private static Function<Student, String> trasformBad = s -> s.getName();
	private static Function<Student, String> trasformBetter = Student::getName;
	public static void main(String[] args) {
		List<String> studentNames = StudentDataBase.getAllStudents()
				.stream() // Stream<Student>
				//.map(Student::getName) // Stream<String>
				//.map(trasformBad)
				.map(trasformBetter)
				//.forEach(System.out::println);
				.collect(Collectors.toList());
		System.out.println(studentNames); 
	}
}
