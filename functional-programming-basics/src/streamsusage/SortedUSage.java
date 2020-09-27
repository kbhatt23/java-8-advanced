package streamsusage;
//sorted with no param will give exception for class that do not implenents comparable

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class SortedUSage {

public static void main(String[] args) {
	List<String> allstudentSortedList = StudentDataBase.getAllStudents().stream()
		.sorted()
		.map(s -> s.getName()+":"+s.getGender())
		.collect(Collectors.toList());
	System.out.println(allstudentSortedList);
	
	List<String> studentListSortedByGPA = StudentDataBase.getAllStudents().stream()
			.sorted(Comparator.comparing(Student::getGpa))
			.map(s -> s.getName()+":"+s.getGender()+":"+s.getGpa())
			.collect(Collectors.toList());
	
	System.out.println(studentListSortedByGPA);
}}
