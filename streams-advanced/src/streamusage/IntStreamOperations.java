package streamusage;

import java.util.stream.IntStream;

public class IntStreamOperations {
public static void main(String[] args) {
	int max= IntStream.of(1,2,3,4,5)
		//.filter(a -> a>5)
		.max()
		.orElse(-1)
		;
	System.out.println(max);
	
	int sum= IntStream.of(1,2,3,4,5)
			.filter(a -> a>5)
			//we cna start with 0 as identity in sum
			.sum()
			;
		System.out.println(sum);
}
}
