package streamsusage.collectors;

import java.util.Map;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class CollectorsGroupingType2_2 {
public static void main(String[] args) {
	Map<String, Integer> totalNOTEbooksbyGender= 
			StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.summingInt(Student::getNoteBooks)));
	System.out.println(totalNOTEbooksbyGender);
	
	Map<String, Double> avgNOTEbooksbyGender= 
			StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getNoteBooks)));
	System.out.println(avgNOTEbooksbyGender);
	
	Map<Integer, Integer> totalNOTEbooksbyGrade= 
			StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.summingInt(Student::getNoteBooks)));
	System.out.println(totalNOTEbooksbyGrade);
	
	Map<Integer, Double> avgNOTEbooksbyGrade= 
			StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.averagingInt(Student::getNoteBooks)));
	System.out.println(avgNOTEbooksbyGrade);
}
}
