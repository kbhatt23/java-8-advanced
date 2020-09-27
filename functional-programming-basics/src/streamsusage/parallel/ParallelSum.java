package streamsusage.parallel;

import java.util.stream.LongStream;

import common.TimeIt;

public class ParallelSum {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Runnable sum1 = () -> {
				long sum = LongStream.rangeClosed(1, 10000000).sum();
				System.out.println("sequential sum is " + sum);
			};
			TimeIt.code(sum1);

			Thread.sleep(1000);

			TimeIt.code(ParallelSum::sumUsingParallel);
		}
	}

	private static void sumUsingParallel() {
		long sum = LongStream.rangeClosed(1, 10000000).parallel().sum();
		System.out.println("parallel sum is " + sum);
	}
}
