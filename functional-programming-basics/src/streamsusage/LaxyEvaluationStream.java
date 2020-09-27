package streamsusage;

import common.Student;
import common.StudentDataBase;
import common.StudentsPRedicates;

public class LaxyEvaluationStream {
public static void main(String[] args) {
	//lazy
	//until we keep sme terminal operation it wont even start pipeleine
	//basically bypasses any intermediate operation
	StudentDataBase.getAllStudents()
					.stream()
					.peek(s -> System.out.println("testing student "+s.getName()))
					.filter(StudentsPRedicates::isStudentGreaterThanThree)
					.peek(s -> System.out.println("student "+s.getName()+" passes filter test"))
					.map(Student::getName)
					.forEach(System.out::println);
					;
}
}
