package streamsusage;

import common.StudentDataBase;

public class LimitUsage {
	public static void main(String[] args) {
		StudentDataBase.getAllStudents().stream().limit(2).forEach(System.out::println);
		;
System.out.println("==================");
		StudentDataBase.getAllStudents().stream().skip(2).forEach(System.out::println);
		;
	}
}
