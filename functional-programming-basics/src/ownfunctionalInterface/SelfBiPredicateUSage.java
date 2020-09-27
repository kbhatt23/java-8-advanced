package ownfunctionalInterface;

public class SelfBiPredicateUSage {
	static SelfBiPredicate<Integer, Integer> sumGreaterThanTen = (a,b) -> a+b > 10;
	static SelfBiPredicate<Integer, Integer> multiplyGreaterThanTwenty = (a,b) -> a*b > 20;
	public static void main(String[] args) {
		System.out.println(sumGreaterThanTen.test(5, 6));
		
		System.out.println(sumGreaterThanTen.and(multiplyGreaterThanTwenty).test(3, 7));
		
		System.out.println(sumGreaterThanTen.or(multiplyGreaterThanTwenty).test(3, 7));
	}
}
