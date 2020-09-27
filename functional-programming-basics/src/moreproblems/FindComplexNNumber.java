package moreproblems;

import java.util.stream.Stream;

public class FindComplexNNumber {
public static void main(String[] args) {
	//start numbers from k and find n values
	int k = 121;
	int n = 51;
	System.out.println(oldWay(k,n));
	System.out.println(newWay(k, n));
}

private static int oldWay(int k, int n) {
	int index = k;
	//every good elmeent count gets incermeneted
	int count = 0;
	int result=0;
	while(count < n) {
		if(index % 2 == 0 && Math.sqrt(index) >20) {
			//condition matches
			result+=index*2;
			count++;
		}
		index++;
	}
	return result;
}

private static int newWay(int k, int n) {
return	Stream.iterate(k, i -> i+1)
			.filter(i -> i % 2 ==0)
			.filter(i -> Math.sqrt(i) > 20)
			.mapToInt(i -> i*2)
			.limit(n)
			.sum();
	
}
}
