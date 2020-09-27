package streamsusage.streamfactorymethods;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class StreamFactoryMethodGenerate {
	public static void main(String[] args) {
		Stream<Integer> generate = Stream.generate(() -> new Random().nextInt(1000));
		Stream<Integer> generate1 = Stream.generate( new Random()::nextInt);

		generate.limit(20).forEach(System.out::println);
		
		Stream<String> customStream = varArg("messi","xavi");
		
//		System.out.println(customStream.count());
		customStream.forEach(System.out::println);
		System.out.println("==============");
		generate1.limit(3).forEach(System.out::println);
	}

	public static Stream<String> varArg(String... items) {
		//System.out.println(items.length);
		return Arrays.stream(items);
	}
}
