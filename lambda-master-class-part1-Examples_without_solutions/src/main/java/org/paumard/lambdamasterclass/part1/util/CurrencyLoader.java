package org.paumard.lambdamasterclass.part1.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyLoader {
public static void main(String[] args) throws IOException{
	String filePath = "C:\\Kanishk\\learning\\java-8\\java-8-advanced\\lambda-master-class-part1-Examples_without_solutions\\data\\currency.txt";
	Map<String, String> loadToCurrencyMap = loadToCurrencyMap(filePath);
	System.out.println(loadToCurrencyMap);
	System.out.println(loadToCurrencyMap.size());
}
//read file and load in key value map for currency items
public static Map<String, String> loadToCurrencyMap(String file) throws IOException{
	
	return Files.lines(Paths.get(file))
			.skip(1) // first line is header for the file
			.map(line -> line.split("="))
			.collect(Collectors.toMap(parts -> parts[0], parts -> parts[1]));
	
	
}
}
