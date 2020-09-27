package streamsusage.numericstreams;

import common.Student;
import common.StudentDataBase;

public class TotalGPAAllStudentsUsingNumericStreams {
public static void main(String[] args) {
	double totalGPAs = StudentDataBase.getAllStudents().stream()
		.mapToDouble(Student::getGpa)
		.sum()
		;
	
	double averageGPA = StudentDataBase.getAllStudents().stream()
			.mapToDouble(Student::getGpa)
			.average().orElse(-1d)
			;
	
	System.out.println(totalGPAs+" , "+averageGPA);
	System.out.println(StudentDataBase.getAllStudents().size());
}
}
