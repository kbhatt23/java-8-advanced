package streamusage;

import java.util.stream.Stream;

public class ReduceUsage {
public static void main(String[] args) {
	//multiple is not provided in int stream also, only sum is there
	int multiplyResult = Stream.of(1,2,3,4,5)
		  .mapToInt(Integer::intValue)
		  .reduce(1, (result,number) -> result*number)
		  //.min().orElse(-1)
		  ;
	System.out.println(multiplyResult);
}
}
