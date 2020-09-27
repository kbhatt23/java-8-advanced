package methodreference;

import java.util.function.BiFunction;

public class BasicBiFunctionReference {
	private static BiFunction<String, String, Integer> completeLengthFun = BasicBiFunctionReference::coolBifyunction;

	private static BiFunction<String, String, String> concatBiFunction = BasicBiFunctionReference::coolBifyunctionConcat;

	private BiFunUtiulity biFunUtiulity = new BiFunUtiulity();
	public static void main(String[] args) {
		BasicBiFunctionReference obj = new BasicBiFunctionReference();
		obj.typeOne();
		System.out.println("=====================");
		obj.typeTwo();
		
		System.out.println("=====================");
		obj.typeThree();
	}

	public void typeOne() {
		System.out.println(completeLengthFun.apply("jai sita ", "ram"));
		System.out.println(concatBiFunction.apply("jai sita ", "ram"));
	}

	public void typeTwo() {
		BiFunction<String, String, Integer> completeLengthFun = this::coolBifyunctionInstance;

		BiFunction<String, String, String> concatBiFunction = this::coolBifyunctionConcatInstance;

		System.out.println(completeLengthFun.apply("jai sita ", "ram"));
		System.out.println(concatBiFunction.apply("jai sita ", "ram"));
	}
	
	public void typeThree() {
		BiFunction<String, String, Integer> completeLengthFun = biFunUtiulity::coolBifyunctionInstance;

		BiFunction<String, String, String> concatBiFunction = biFunUtiulity::coolBifyunctionConcatInstance;

		System.out.println(completeLengthFun.apply("jai sita ", "ram"));
		System.out.println(concatBiFunction.apply("jai sita ", "ram"));
	}

	private static int coolBifyunction(String a, String b) {
		return a.length() + b.length();
	}

	private static String coolBifyunctionConcat(String a, String b) {
		return a.concat(b);
	}
	
	private  int coolBifyunctionInstance(String a, String b) {
		return a.length() + b.length();
	}

	private  String coolBifyunctionConcatInstance(String a, String b) {
		return a.concat(b);
	}
}
class BiFunUtiulity{
	public  int coolBifyunctionInstance(String a, String b) {
		return a.length() + b.length();
	}

	public  String coolBifyunctionConcatInstance(String a, String b) {
		return a.concat(b);
	}
}
