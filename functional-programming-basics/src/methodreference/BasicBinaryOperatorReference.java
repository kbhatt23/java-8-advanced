package methodreference;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BasicBinaryOperatorReference {
	private static BiFunction<String, String, Integer> completeLengthFun = BasicBinaryOperatorReference::coolBifyunction;

	private static BinaryOperator<String> concatBiFunction = BasicBinaryOperatorReference::coolBifyunctionConcat;

	private BasicBinaryOperatorReferenceUtiulity biFunUtiulity = new BasicBinaryOperatorReferenceUtiulity();
	public static void main(String[] args) {
		BasicBinaryOperatorReference obj = new BasicBinaryOperatorReference();
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

		BinaryOperator<String> concatBiFunction = this::coolBifyunctionConcatInstance;

		System.out.println(completeLengthFun.apply("jai sita ", "ram"));
		System.out.println(concatBiFunction.apply("jai sita ", "ram"));
	}
	
	public void typeThree() {
		BiFunction<String, String, Integer> completeLengthFun = biFunUtiulity::coolBifyunctionInstance;

		BinaryOperator<String> concatBiFunction = biFunUtiulity::coolBifyunctionConcatInstance;

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
class BasicBinaryOperatorReferenceUtiulity{
	public  int coolBifyunctionInstance(String a, String b) {
		return a.length() + b.length();
	}

	public  String coolBifyunctionConcatInstance(String a, String b) {
		return a.concat(b);
	}
}
