package declarativeVsImperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {
public static void main(String[] args) {
	List<Integer> l1 = Arrays.asList(1,2,4,5,6,3,4,5,2,4,8,22,11,223,43,23,32,23);
	
	//remove duplicates
	//Set<Integer> setOld  = new HashSet<Integer>();
	List<Integer> l2 = new ArrayList<Integer>();
	for(int num : l1) {
		if(!l2.contains(num)) {
			l2.add(num);
			//setOld.add(num);
		}
	}
	System.out.println("unique old way list "+l2);
	
	List<Integer> uniqueNewList = l1.stream().distinct().collect(Collectors.toList());
	
	System.out.println("unique new way list "+uniqueNewList);
}

}
