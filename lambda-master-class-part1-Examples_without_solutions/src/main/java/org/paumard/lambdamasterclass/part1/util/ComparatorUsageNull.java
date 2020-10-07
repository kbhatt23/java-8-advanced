package org.paumard.lambdamasterclass.part1.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorUsageNull {
public static void main(String[] args) {

	List<String> strings = Arrays.asList("ram","sita ram",null, "ramduta hanuman", "hanuman duta kanishk" , null,"ma bhavani");

	//moves all null to the left
	Comparator<String> c = (a,b) -> {
		if(a == null) {
			//return -1;
			//to push null to right
			return 1;
		}
		if(b == null) {
			//return 1;
			// to push nulls to right
			return -1;
		}
		return a.compareTo(b);
	};
	
	
	//Collections.sort(strings,c);
	
	Collections.sort(strings,Comparator.nullsFirst(Comparator.naturalOrder()));
	
	System.out.println(strings);
}

}
