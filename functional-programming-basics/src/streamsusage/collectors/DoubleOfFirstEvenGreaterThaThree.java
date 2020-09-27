package streamsusage.collectors;

import java.util.stream.IntStream;

public class DoubleOfFirstEvenGreaterThaThree {
public static void main(String[] args) {
	IntStream numbers = IntStream.rangeClosed(1, 8);
	
	int result = numbers.
	boxed()
	.filter( i -> i > 3)
			.filter(i -> i % 2 == 0)
			.findFirst()
			.map(i -> i*2)
			.orElse(-1)
			;
	
	System.out.println(result);
	numbers = IntStream.rangeClosed(1, 8);
	result=numbers
			.peek(a -> System.out.println("starting piplein for "+a))
	.filter( i -> i > 3)
			.filter(i -> i % 2 == 0)
			.peek(a -> System.out.println("starting doubling for "+a))
			.map(i -> i*2)
			.peek(a -> System.out.println("doubled for "+a))
			.findFirst()
			.orElse(-1)
			;
	System.out.println(result);
}
}
