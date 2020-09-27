package streamsusage;

import java.util.Arrays;
import java.util.List;

public class MinMaxUsingReduce {
public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(3,42,2,1,4,344,32);
	//	List<Integer> numbers = Arrays.asList();
	
	int minUsingMin = numbers.stream().mapToInt(Integer::valueOf).min().orElse(Integer.MAX_VALUE);
	
	int minusingreduce=numbers.stream().mapToInt(Integer::valueOf).reduce(Integer::min).orElse(Integer.MAX_VALUE);
	System.out.println(minUsingMin +" , "+minusingreduce);
	
int maxUsingMin = numbers.stream().mapToInt(Integer::valueOf).max().orElse(Integer.MIN_VALUE);
	
	int maxusingreduce=numbers.stream().mapToInt(Integer::valueOf).reduce(Integer::max).orElse(Integer.MIN_VALUE);
	System.out.println(maxUsingMin +" , "+maxusingreduce);
}
}
