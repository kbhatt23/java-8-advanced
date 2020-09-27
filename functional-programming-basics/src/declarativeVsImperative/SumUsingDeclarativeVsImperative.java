package declarativeVsImperative;

import java.util.stream.IntStream;

public class SumUsingDeclarativeVsImperative {
public static void main(String[] args) {
	int sumOld =0;
	for(int i=1 ; i <=100; i++) {
		sumOld+=i;
	}
	System.out.println("old way sum "+sumOld);
	
	int sumNEw = IntStream.rangeClosed(1, 100).sum();
	
	System.out.println("new way sum "+sumNEw);
}
}
