package streamsusage.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumMinMax {
	public static void main(String[] args) {
		int sum = IntStream.rangeClosed(1, 100).sum();

		double average = IntStream.rangeClosed(1, 100).average().orElse(1d);

		int min = IntStream.rangeClosed(1, 100).min().orElse(-1);

		int max = IntStream.rangeClosed(1, 100).max().orElse(-1);
		System.out.println(sum + " , " + average + " , " + min + " , " + max);

		List<Integer> listNums = Arrays.asList();
		System.out.println("=========");
		System.out.println(listNums.stream().mapToInt(Integer::intValue).sum());

		listNums.stream().mapToInt(Integer::intValue).min().ifPresent(System.out::println);
		
		IntStream.rangeClosed(1, 100).min().ifPresent(System.out::println);
		
		IntStream.rangeClosed(1, 100).max().ifPresent(System.out::println);
		
	System.out.println("=============");
	List<Integer> collect = IntStream.rangeClosed(1, 11).mapToObj(i -> i).collect(Collectors.toList());
	System.out.println(collect);
	}
}
