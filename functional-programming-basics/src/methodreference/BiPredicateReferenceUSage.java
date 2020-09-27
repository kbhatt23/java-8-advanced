package methodreference;

import java.util.function.BiPredicate;

public class BiPredicateReferenceUSage {
	//private static Predicate<String> type1Empty = String::isEmpty;

	private static BiPredicate<String,String> type2Empty = BiPredicateReferenceUSage::isStrEmpty;

	public static void main(String[] args) {
		BiPredicateReferenceUSage obj = new BiPredicateReferenceUSage();
		String str = "";
		String str1 = "jai sita ram";
		//System.out.println(type1Empty.test(str,str1));
		//System.out.println("===========");
		
		System.out.println(type2Empty.test(str,str1));
		
		System.out.println("============");
		BiPredicate<String,String> type3Empty = obj::isStrEmptyInstance;
		System.out.println(type3Empty.test(str,str1));
	}

	public static boolean isStrEmpty(String str, String str1) {
		return str.length() == 0 || str1.length()==0;
	}
	
	public  boolean isStrEmptyInstance(String str,String str1) {
		return str.length() == 0|| str1.length()==0;
	}
}
