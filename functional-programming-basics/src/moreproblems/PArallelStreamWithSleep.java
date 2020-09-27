package moreproblems;

import common.StudentDataBase;

public class PArallelStreamWithSleep {
public static void main(String[] args) {
	System.out.println("game started");
	long count = StudentDataBase.getAllStudents()
		.stream()
		//.parallel()
		.map(a -> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return a.getName();
		})
		.count()
		;
	System.out.println(count);
	
	System.out.println("done");
}
}
