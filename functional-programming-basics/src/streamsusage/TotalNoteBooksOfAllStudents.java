package streamsusage;

import common.Student;
import common.StudentDataBase;
import common.StudentsPRedicates;

public class TotalNoteBooksOfAllStudents {
public static void main(String[] args) {
	int toatlBooks = StudentDataBase.getAllStudents()
		.stream()
		.mapToInt(Student::getNoteBooks)
		.sum();
	
	int toatlBooks1 = StudentDataBase.getAllStudents()
			.stream()
			.mapToInt(Student::getNoteBooks)
			.reduce(0, Integer::sum);
	
	int toatlBooks2 = StudentDataBase.getAllStudents()
			.stream()
			.mapToInt(Student::getNoteBooks)
			.reduce(Integer::sum).orElse(0);
	System.out.println(toatlBooks);
	System.out.println(toatlBooks1);
	System.out.println(toatlBooks2);
	int toatlBooksThirdGrdOnly = StudentDataBase.getAllStudents()
			.stream()
			.filter(StudentsPRedicates.IS_GRADE_GREATER_THAN_THREE)
			.mapToInt(Student::getNoteBooks)
			.reduce(Integer::sum).orElse(0);
	System.out.println(toatlBooksThirdGrdOnly);
	
	int toatlBooksLessThirdGrdOnly = StudentDataBase.getAllStudents()
			.stream()
			.filter(s -> s.getGradeLevel() < 3)
			.mapToInt(Student::getNoteBooks)
			.reduce(Integer::sum).orElse(0);
	System.out.println(toatlBooksThirdGrdOnly);
	System.out.println(toatlBooksLessThirdGrdOnly);
}
}
