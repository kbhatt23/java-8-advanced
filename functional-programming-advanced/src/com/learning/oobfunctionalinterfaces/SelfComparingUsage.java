package com.learning.oobfunctionalinterfaces;

import com.learning.lambdas.Student;

public class SelfComparingUsage {
public static void main(String[] args) {
	Student stu1 = new Student(1, "kannu", true, "kannu@gmail.com", null);
	
	Student stu2 = new Student(1, "lappu", true, "lappu@gmail.com", null);

	System.out.println(SelfComparator.comparing(Student::getId).
			thenComparing(Student::getName)
			.compare(stu2, stu1));
}
}
