package streamsusage.streamfactorymethods;

import java.util.Random;
import java.util.stream.Stream;

//used to create infinte elemen contains stream
public class StreamFactoryMethodIterate {
	public static void main(String[] args) {
		// want to generate 1 to 10 Integer
		// firs tieration i willbe woll return 1
		// secon iteration i will be 1 return 2
		// thoird iteration i will be 2 returns 3...and so on
		// if we put 0 it also returns 0 as first element
		Stream<Integer> intStreamInfinite = Stream.iterate(1, i -> i + 1);

		intStreamInfinite.limit(10).forEach(num -> System.out.println("numer found " + num));
		System.out.println("=============");
		
		intStreamInfinite = Stream.iterate(1, i -> i + 1);
		int sum = intStreamInfinite.limit(10).reduce(0, Integer::sum);
		System.out.println(sum);
		
		System.out.println("======================");
		Random random = new Random();
		Stream<Integer> iterate = Stream.iterate(random.nextInt(100),  i -> i+random.nextInt(2));
		
		iterate.limit(10).forEach(System.out::println);
	}
}
