package streamsusage.collectors;

import java.util.stream.Collectors;

import common.StudentDataBase;

public class CountingCollector {
	public static void main(String[] args) {
		long count1 = StudentDataBase.getAllStudents().stream()
			.collect(Collectors.counting());
		
		long count2 = StudentDataBase.getAllStudents().stream().count();
	
		System.out.println(count1);
		System.out.println(count2);
	}
}
