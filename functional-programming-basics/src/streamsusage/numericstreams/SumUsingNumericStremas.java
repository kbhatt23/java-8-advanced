package streamsusage.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumUsingNumericStremas {
	public static void main(String[] args) {
		List<Integer> intNums = Arrays.asList(1, 2, 3, 4, 5, 6);

		int sumUSingObj = intNums.stream().reduce(0, Integer::sum);
		System.out.println(sumUSingObj);

		int sumUsingIntStream = IntStream.rangeClosed(1, 6).sum();
		System.out.println(sumUsingIntStream);

		List<Double> doubleNums = Arrays.asList(1.11, 2.22, 3.33, 4.44, 5.55, 6.66);
		Double sumDouble = doubleNums.stream().reduce(0d, Double::sum);
		System.out.println(sumDouble);

		double doubleNumsUSingNumericStream = doubleNums.stream().mapToDouble(Double::valueOf).sum();
		System.out.println(doubleNumsUSingNumericStream);
		
	}
}
