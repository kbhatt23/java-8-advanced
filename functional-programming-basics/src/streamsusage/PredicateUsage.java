package streamsusage;

import common.Student;
import common.StudentDataBase;

public class PredicateUsage {
	public static void main(String[] args) {
		/* List<String> femleNames = */ StudentDataBase.getAllStudents().stream()
				.peek(s -> System.out.println("validating for student "+s.getName()))
				.filter(s -> "female".equals(s.getGender()))
				.peek(s -> System.out.println("found female student "+s.getName()))
				.filter(Student::isExcellentStudent)
				.peek(s -> System.out.println("found excellent female student "+s.getName()))
				.map(Student::getName)
				.peek(s -> System.out.println("transformed to name"+s))
				 .forEach(System.out::println);
				//.collect(Collectors.toList());
		//System.out.println(femleNames);
	}
}
