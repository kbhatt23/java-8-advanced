package com.learning.lambdas;

import java.util.Optional;

public class StudentOptionalUsage {
public static void main(String[] args) {
	Optional<Student> findStudent = findStudent();
	Student stu = findStudent.isPresent() ? findStudent.get() : null;
	System.out.println(stu);
	
	//transformation magic
	String vehicleNumber = findStudent
			.filter(Student::isFootballFan)
			.flatMap(Student::getVehicle)
			.map(Vehicle::getNumber)
			.orElse("kuch nahi")
			;
	System.out.println(vehicleNumber);
}

public static Optional<Student> findStudent() {
	Student stu = new Student(1, "radha krishna", true, "radkarihna@email.com",
			new Vehicle("car", "108")
			//null
			);
	
	//return Optional.of(null);
	//return Optional.ofNullable(null);		
	return Optional.ofNullable(stu);
}
}
