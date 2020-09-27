package methodreference;

import java.util.function.Predicate;

public class PredicateReferenceUSage {
	private static Predicate<String> type1Empty = String::isEmpty;

	private static Predicate<String> type2Empty = PredicateReferenceUSage::isStrEmpty;

	public static void main(String[] args) {
		PredicateReferenceUSage obj = new PredicateReferenceUSage();
		String str = "";
		System.out.println(type1Empty.test(str));
		System.out.println("===========");
		
		System.out.println(type2Empty.test(str));
		
		System.out.println("============");
		Predicate<String> type3Empty = obj::isStrEmptyInstance;
		System.out.println(type3Empty.test(str));
	}

	public static boolean isStrEmpty(String str) {
		return str.length() == 0;
	}
	
	public  boolean isStrEmptyInstance(String str) {
		return str.length() == 0;
	}
}
