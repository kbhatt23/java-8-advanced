package streamsusage;

import java.util.stream.Stream;

import common.Student;
import common.StudentDataBase;

public class StreamIsOneTimeUsable {
	public static void main(String[] args) {
		Stream<Student> studentsStream = StudentDataBase.getAllStudents().stream();
		//can be used only once, even intermediate operation kills the stream
		studentsStream.filter(Student::isExcellentStudent);

		studentsStream.map(Student::getName).forEach(System.out::println);
	}
}
