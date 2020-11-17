package streamusage;

import java.util.stream.IntStream;

public class InfiniteStremaBasic {
public static void main(String[] args) {
	IntStream.iterate(0,  i -> i-1)
			//.limit(10)
			.forEach(System.out :: println);
} 

}
