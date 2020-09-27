package ownfunctionalInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import common.Student;
import common.StudentDataBase;

public class StudentFunctionUsage {
	static BiConsumer<String, String> printMap = (a, b) -> System.out.println(a + " : " + b);
	static Function<List<Student>, Map<String, String>> convertStudentActivityMap = (students) -> {
		Map<String, String> mapItems = new HashMap<>();
		for (Student student : students) {
			mapItems.put(student.getName(), student.getActivities().stream().collect(Collectors.joining(",")));
		}
		return mapItems;
	};
	static BiFunction<List<Student>, Predicate<Student>,Map<String, String>> convertStudentActivityMapBiFun = (students,condition) -> {
		Map<String, String> mapItems = new HashMap<>();
		students.forEach(student -> {
			if(condition.test(student)) {
				mapItems.put(student.getName(), student.getActivities().stream().collect(Collectors.joining(",")));
			}
		});
				return mapItems;
	};

	public static void main(String[] args) {

		Map<String, String> applyMap = convertStudentActivityMap.apply(StudentDataBase.getAllStudents());
		applyMap.forEach(printMap);

		System.out.println("=======bifunction=============");

		convertStudentActivityMapBiFun.apply(StudentDataBase.getAllStudents(), PredicateUsage.higherThanGPA)
			.forEach(printMap);
	}
}
