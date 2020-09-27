package ownfunctionalInterface;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

import common.Student;
import common.StudentDataBase;

public class BinaryOperatorUsage {
public static void main(String[] args) {
	//finding student having more gpa
	BinaryOperator<Student> higherGPAStudenOperator = (student1,student2) -> student1.getGpa() >= student2.getGpa() ? student1: student2;
	
	List<Student> students = StudentDataBase.getAllStudents();
	System.out.println(higherGPAStudenOperator.apply(students.get(0), students.get(1)).getName());
	
	Comparator<Student> sortStudentByGPAComoparator = (student1,student2) -> Double.valueOf(student1.getGpa()).compareTo(Double.valueOf(student2.getGpa()));
	
	BinaryOperator<Student> minBy = BinaryOperator.minBy(sortStudentByGPAComoparator);
	BinaryOperator<Student> maxBy = BinaryOperator.maxBy(sortStudentByGPAComoparator);
	System.out.println(minBy.apply(students.get(0), students.get(1)).getName());
	System.out.println(maxBy.apply(students.get(0), students.get(1)).getName());
	
}
}
