package streamusage;

import java.util.stream.DoubleStream;

public class InfiniteStreamGenerate {
public static void main(String[] args) {
	DoubleStream.generate(Math::random)
			.limit(100)
			.forEach(System.out::println);
}
}
