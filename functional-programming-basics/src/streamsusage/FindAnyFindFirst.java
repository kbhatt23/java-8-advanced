package streamsusage;

import common.Student;
import common.StudentDataBase;
import common.StudentsPRedicates;

public class FindAnyFindFirst {
	public static void main(String[] args) {
		// bioth methods returns smae in sequnetial stream
		// in paralel stream findFirst returns actual first item present in collection
		// and in parrallel findany returns any value that is returned true by any
		// thread
//		-> basically running n times result might be different
		
		Student student = StudentDataBase.getAllStudents().stream()
				.parallel()
				.filter(StudentsPRedicates::isStudentGreaterThanThree)
				//.findFirst()
				//find any can return any object that was filtered succesfullt
				//if thread one gets cheudled it return item it have ,or else other and so on 
				//this effect is not there in sequential stream
				.findAny()
				//.findFirst()
				.orElse(null);
		System.out.println(student);
	}
}
