package streamsusage;

import java.util.Comparator;

import common.Student;
import common.StudentDataBase;
import common.TimeIt;

public class HighestGPAStudentName {
public static void main(String[] args) {
	
	TimeIt.code(HighestGPAStudentName::executeTask);
}
public static void executeTask() {

	String highestGPAStudentName = StudentDataBase.getAllStudents()
		.stream()
		.max(Comparator.comparing(Student::getGpa))
		.map(Student::getName)
		.orElse("No one is there");
	System.out.println(highestGPAStudentName);


}
}
