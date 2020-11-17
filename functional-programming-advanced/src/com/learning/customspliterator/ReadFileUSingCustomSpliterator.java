package com.learning.customspliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadFileUSingCustomSpliterator {
public static void main(String[] args) {
	String filePath  ="C:\\Kanishk\\learning\\java-8\\java-8-advanced\\functional-programming-advanced\\employee-custom-spliterator.txt";
	try(Stream<String> lineStream= Files.lines(Paths.get(filePath))){
		Spliterator<Employee> customFileSpliterator = new CustomFileSpliterator(lineStream.spliterator());
		Stream<Employee> streamEmployee = StreamSupport.stream(customFileSpliterator, false);
		streamEmployee
			.forEach(System.out::println);
	}catch (IOException e) {
	}
}
}
