package optionalusage;

import java.util.Arrays;
import java.util.Optional;

import common.StudentV1;

public class OptionalFlapMapUsage {
public static void main(String[] args) {
	Optional<StudentV1> optionalStudent = fetchStudentV1FromDB();
	//badAppriach(optionalStudent);
	betterAppriach(optionalStudent);
	betterAppriachWithDefault(optionalStudent);
}

private static void badAppriach(Optional<StudentV1> optionalStudent) {
	//need to print mobile numer if present
	optionalStudent.map(StudentV1::getMobileNumber)
	.map(Optional::get)
			.ifPresent(System.out::println);
}

private static void betterAppriach(Optional<StudentV1> optionalStudent) {
	//need to print mobile numer if present
	optionalStudent.flatMap(StudentV1::getMobileNumber)
	//.map(Optional::get)
	.filter(n -> {
		try {
			Integer.parseInt(n);
			return true;
		}catch (Exception e) {
			return false;
		}
	})
			.ifPresent(System.out::println);
}
private static void betterAppriachWithDefault(Optional<StudentV1> optionalStudent) {
	//need to print mobile numer if present
	String number =optionalStudent.flatMap(StudentV1::getMobileNumber)
			.filter(n -> {
				try {
					Integer.parseInt(n);
					return true;
				}catch (Exception e) {
					return false;
				}
			})
	//.map(Optional::get)
			//.ifPresent(System.out::println);
	.orElse("number not found");
	System.out.println("number found "+number);
}

private static Optional<StudentV1> fetchStudentV1FromDB() {
	StudentV1 student =new StudentV1("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball")
    		,new String[]{"messi", "ronaldinho", "xavi"}
    		,10,"9292992");
	
	Optional<StudentV1> optionalStudent = Optional.ofNullable(student);
	return optionalStudent;
}
}
