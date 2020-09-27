package streamsusage.collectors;


import common.Student;
import common.StudentDataBase;
import static java.util.stream.Collectors.joining;

public class JoiningCollectorUsage2 {
	public static void main(String[] args) {
		String joiningWithPReANdPostfix=
		StudentDataBase.getAllStudents().stream()
			.map(Student::getName)
			.collect(joining(",","start: "," :end"));
		System.out.println(joiningWithPReANdPostfix);
	}

}
