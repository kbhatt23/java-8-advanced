package streamsusage.collectors;

import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class SumAvergaeCollector {
public static void main(String[] args) {
	double sumofGPAS = StudentDataBase.getAllStudents().stream()
			.collect(Collectors.summingDouble(Student::getGpa));
	System.out.println(sumofGPAS);
	System.out.println("complex avg "+sumofGPAS/StudentDataBase.getAllStudents().size());
	
	double avgGPAS = StudentDataBase.getAllStudents().stream()
			.collect(Collectors.averagingDouble(Student::getGpa));
	System.out.println(avgGPAS);
	
	//toal notebooks
	System.out.println("sum of all notebooks "+StudentDataBase.getAllStudents().stream()
		.collect(Collectors.summingInt(Student::getNoteBooks)));
	
	System.out.println(StudentDataBase.getAllStudents().stream().map(Student::getNoteBooks).reduce(0, Integer::sum));
	
}
}
