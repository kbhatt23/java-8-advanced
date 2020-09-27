package common;

import java.util.function.Predicate;

public class StudentsPRedicates {

	public static Predicate<Student> IS_GRADE_GREATER_THAN_THREE = s -> s.getGradeLevel() >=3;
	public static Predicate<Student> IS_FEMALE_STUDENT = s -> "female".equals(s.getGender());
	
	public static boolean isStudentGreaterThanThree(Student s) {
		//System.out.println("chekcing student "+s.getName() +" if grade greater or equal to 3");
		return  s.getGradeLevel() >=3;
	}
	
	
}
