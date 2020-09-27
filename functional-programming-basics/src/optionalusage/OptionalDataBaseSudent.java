package optionalusage;

import java.util.Arrays;
import java.util.Optional;

import common.Student;
import common.StudentDataBase;

public class OptionalDataBaseSudent {

	public static void main(String[] args) {
		Student findStudentFromDataBase = findStudentFromDataBase("Adam");
	
		//bad approach
		//badApprachUsage(findStudentFromDataBase);
		
		System.out.println("new approach=================");
		Optional<Student> findStudentOptionalFromDataBase = findStudentOptionalFromDataBase("Adam");
		
		//aprooach1_optional(findStudentOptionalFromDataBase);
		
		System.out.println("approach 2 =========================");
		aprooach2_optional(findStudentOptionalFromDataBase);
		}

	private static void aprooach1_optional(Optional<Student> findStudentOptionalFromDataBase) {
		if(findStudentOptionalFromDataBase.isPresent()) {
			Student student = findStudentOptionalFromDataBase.get();
			//no need of null cheikc of student
			//if wrapper options is preent is true mean data is there
			//if false calling get method gives exception
			if(student.getName() != null) {
				System.out.println("size of optional student is "+student.getName().length());
			}else {
				System.err.println("optional1: stuent have empty name");
			}
		}else
		{
			System.err.println("student optional is empty");
		}
	}
	
	
	private static void aprooach2_optional(Optional<Student> findStudentOptionalFromDataBase) {
		//mapping gets called only if empty

		findStudentOptionalFromDataBase.map(Student::getName)
				.map(String::length)
				.ifPresent(num -> System.out.println("optional2 student name length is "+num));
				
	}
	
	private static void badApprachUsage(Student findStudentFromDataBase) {
		if(findStudentFromDataBase != null) {
			String name = findStudentFromDataBase.getName();
			if(name != null) {
				System.out.println("name length is "+name.length());
			}else {
				System.err.println("student have invalid name");
			}
		}else {
			System.err.println("no student found");
		}
	}
	

	private static Student findStudentFromDataBase(String name) {
		//assuming it was comming from D.B
		//return new Student("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball")
        	//	,new String[]{"messi", "ronaldinho", "xavi"}
        		//,10);
		//asumiong null value from d.b
		//return null;
		return new Student(null,2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball")
        		,new String[]{"messi", "ronaldinho", "xavi"}
        		,10);
	}
	//we always wrap object of student within optional
	//hence object optional can never be null, however data inside it can still be null or valid object
	private static Optional<Student> findStudentOptionalFromDataBase(String name) {
		//assume we are taking from dat base
		Student student = StudentDataBase.getAllStudents().stream().filter(s -> s.getGpa()>4).findFirst().orElse(null);
		//Student student = new Student(null,2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball")
        	//	,new String[]{"messi", "ronaldinho", "xavi"}
        		//,10);
		//if stuent is null then it will return empty optional(canm not use of method in null case)
		//if student is present it passes it
		return Optional.ofNullable(student);
	}
}
