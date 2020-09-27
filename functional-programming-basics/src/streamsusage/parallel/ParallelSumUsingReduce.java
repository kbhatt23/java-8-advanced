package streamsusage.parallel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import common.TimeIt;

public class ParallelSumUsingReduce {
	public static void main(String[] args) throws InterruptedException {
		List<Long> numbers = LongStream.range(1, 10000000).boxed().collect(Collectors.toList());
		for (int i = 0; i < 10; i++) {
			TimeIt.code(() -> {
				Long sum = numbers.stream().reduce(0l, Long::sum);
				System.out.println("sum using sequential " + sum);
			});

			Thread.sleep(1000);

			TimeIt.code(() -> {
				Long sum = numbers.stream().parallel().reduce(0l, Long::sum);
				System.out.println("sum using parallel " + sum);
			});
		}
	}
}
