package ownfunctionalInterface;

public class SelfPredicateUSage {

	public static void main(String[] args) {
		SelfPredicate<String> notNull = (str) -> {
			System.out.println("checking null condition");
			return str != null;
		};

		SelfPredicate<String> notempty = (str) -> {
			System.out.println("checking empty condition");
			return str.length() > 0;
		};
		
		SelfPredicate<String> nullItem = (str) -> {
			System.out.println("checking if null condition");
			return str == null;
		};

		SelfPredicate<String> emptyItem = (str) -> {
			System.out.println("checking if empty condition");
			return str.length() == 0;
		};

		System.out.println(notNull.and(notempty).test(null));

		System.out.println(notNull.not().test(null));

		System.out.println(nullItem.or(emptyItem).test(null));
	}
}
