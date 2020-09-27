package streamsusage;

import java.util.Arrays;
import java.util.List;

public class AllAndAnyAndNoneMatch {
	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(3, 4, 5, 6, 8, 9);
		//nums.add(11);
		
		List<Integer> nums1 = Arrays.asList(7, 7, 5, 6, 8, 9);
		
		List<Integer> nums2 = Arrays.asList(7, 7, 9, 16, 8, 9);
		
		List<Integer> nums3 = Arrays.asList(1,3,4,1,5,4);
		// need to chekc if ll elments are greater than 5
		// al mathch return true if all test predicates return true . else return false
		// if finds first predicate which returns false , breaks the loop
		boolean allMatch = /*nums*/nums2.stream().allMatch(num -> {
			System.out.println("validating for number " + num);
			return num > 5;
		});
		System.out.println(allMatch);
		System.out.println("================");
		//al predicate are false -> then return true , other wise false
		//breaks the loop once any one predicate tests to true
		boolean noneMatch = /*nums*/nums.stream().noneMatch(num -> {
			System.out.println("validating for number " + num);
			return num > 5;
		});
		System.out.println(noneMatch);
		
		System.out.println("================");
		boolean anyMatch = /*nums*/nums3.stream().anyMatch(num -> {
			System.out.println("validating for number " + num);
			return num > 5;
		});
		//if any predicat tests to true it brekas and returns true ,else false
		System.out.println(anyMatch);
	}
}
