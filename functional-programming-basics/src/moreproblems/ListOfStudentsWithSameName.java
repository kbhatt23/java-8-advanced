package moreproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class ListOfStudentsWithSameName {
public static void main(String[] args) {
	//usingStreams();
	usingCustomCollection();
}

private static void usingCustomCollection() {
	Map<String, List<Student>> groupedMap = StudentDataBase.groupByCustomProperty(Student::getGender, StudentDataBase.getAllStudents());
	StudentDataBase.printGroupedMap(groupedMap);
}

private static void usingStreams() {
	Map<String, List<Student>> commonNameStudentnts=
	StudentDataBase.getAllStudents().stream()
			.collect(Collectors.groupingBy(Student::getName));
	
	StudentDataBase.printGroupedMap(commonNameStudentnts);
	
	
}


}
