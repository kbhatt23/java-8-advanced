package com.learning.customspliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadingUsingForLoop {
public static void main(String[] args) throws IOException{
	String filePath  ="C:\\Kanishk\\learning\\java-8\\java-8-advanced\\functional-programming-advanced\\employee-custom-spliterator.txt";
	List<String> readAllLines = Files.readAllLines(Paths.get(filePath));
	List<Employee> employees = new ArrayList<>();
	int propertySize = 3;
	int fileLinesSize = readAllLines.size();
	if(fileLinesSize % propertySize != 0)
		throw new RuntimeException("File is not set correctly");
	int employeeCount = fileLinesSize/propertySize;
	for(int i= 0,employeeCounter = 0 ; employeeCounter < employeeCount; i = i+3, employeeCounter++ ) {
		employees.add(new Employee(readAllLines.get(i), readAllLines.get(i+1), Integer.parseInt(readAllLines.get(i+2))));
	}
	employees.forEach(System.out::println);
}


}
