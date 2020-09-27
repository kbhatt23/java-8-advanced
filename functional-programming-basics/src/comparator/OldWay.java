package comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Student;
import common.StudentDataBase;

public class OldWay {
public static void main(String[] args) {
	List<Student> allStudents = StudentDataBase.getAllStudents();
	System.out.println("=====before sorting==============");
	//allStudents.forEach(a -> System.out.println("student "+a.getName()+" with GPA "+a.getGpa()));
	allStudents.forEach(System.out::println);
	System.out.println("=====after simple sorting==============");
	Collections.sort(allStudents, new DoubleComparator());
	//allStudents.forEach(a -> System.out.println("student "+a.getName()+" with GPA "+a.getGpa()));
	
	allStudents.forEach(System.out::println);
	
	//Comparator<Student> c = Comparator.comparing(Student::getGpa).thenComparing(Comparator.comparing(Student::getName)).reversed();
	
	//Comparator<Student> c = Comparator.comparing(Student::getGpa).reversed().thenComparing(Comparator.comparing(Student::getName));
	//handling null and pushing all nulls at the begining
	//Comparator<Student> c = Comparator.nullsFirst(Comparator.comparing(Student::getGpa).reversed().thenComparing(Comparator.comparing(Student::getName)));
	
	
	//all null at the end
	
	Comparator<Student> c = Comparator.nullsLast(Comparator.comparing(Student::getGpa).reversed().thenComparing(Comparator.comparing(Student::getName)));
	allStudents.sort(c);
	
	System.out.println("after reverse comparator sorting");
	//allStudents.forEach(a -> System.out.println("student "+a.getName()+" with GPA "+a.getGpa()));
	allStudents.forEach(System.out::println);
} 

}
class DoubleComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		//adding null thing
		//assuing item is null then we push at the end
		//pushing all nulls to the left
		//if(o1 == null) {
			//return -1;
		//}
		//if(o2 == null) {
			//return 1;
		//}
		
		//to push all nulls to right
		
		if(o1 == null) {
			return 1;
		}
		if(o2 == null) {
			return -1;
		}
		
		//first based on gpa
		//if gpa is same then sort by name
		return o1.getGpa() > o2.getGpa() ? 1 : (o1.getGpa() == o2.getGpa() ? o1.getName().compareTo(o2.getName()): -1);
	}
	
}
