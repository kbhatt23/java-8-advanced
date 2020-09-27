package streamsusage;

import common.Student;
import common.StudentDataBase;

public class DistinctUSage {
public static void main(String[] args) {
	StudentDataBase.getAllStudents().stream()
		.distinct()
		//.map(Student::getName)
		.forEach(System.out::println);
	
	System.out.println("total students "+StudentDataBase.getAllStudents().stream()
		.count());

	System.out.println("total unique named students "+StudentDataBase.getAllStudents().stream()
			.distinct()
			.count());
}
}
