package methodreference;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BasicUnaryOperatorReference {
	private static UnaryOperator<String> upperCaseFunction = BasicUnaryOperatorReference::coolUpperCaseFunction;

	private static Function<String, Integer> lengthFunction = BasicUnaryOperatorReference::coolLengthFunction;

	private static UnaryOperator<Integer> badLengthFunction = BasicUnaryOperatorReference::badLengthFunction;
	
	private BasicUnaryOperatorReferenceUtility utility = new BasicUnaryOperatorReferenceUtility();

	public static void main(String[] args) {
		BasicUnaryOperatorReference obj = new BasicUnaryOperatorReference();
		obj.typeOne();

		System.out.println("===============");
		obj.typeTwo();
		
		System.out.println("===============");
		obj.typeThree();
	}

	public void typeOne() {
		System.out.println(upperCaseFunction.apply("jai shree ram"));
		System.out.println(lengthFunction.apply("jai shree ram"));
		System.out.println(badLengthFunction.apply(23));
	}

	public void typeTwo() {
		UnaryOperator<String> upperInstanceCaseFunction = this::coolUpperCaseFunctionInstance;
		Function<String, Integer> lengthFunction = this::coolLengthFunctionInstance;
		UnaryOperator<Integer> badLengthFunction = this::badLengthFunctionInstance;
		System.out.println(upperInstanceCaseFunction.apply("jai shree ram"));
		System.out.println(lengthFunction.apply("jai shree ram"));
		System.out.println(badLengthFunction.apply(23));
	}
	
	public void typeThree() {
		UnaryOperator<String> upperInstanceCaseFunction = utility::coolUpperCaseFunctionInstance;
		Function<String, Integer> lengthFunction = utility::coolLengthFunctionInstance;
		UnaryOperator<Integer> badLengthFunction = utility::badLengthFunctionInstance;
		System.out.println(upperInstanceCaseFunction.apply("jai shree ram"));
		System.out.println(lengthFunction.apply("jai shree ram"));
		System.out.println(badLengthFunction.apply(23));
	}

	public static String coolUpperCaseFunction(String str) {
		return str.toUpperCase();
	}

	public static int coolLengthFunction(String str) {
		return str.length();
	}

	public static int badLengthFunction(int str) {
		return str;
	}

	public String coolUpperCaseFunctionInstance(String str) {
		return str.toUpperCase();
	}

	public int coolLengthFunctionInstance(String str) {
		return str.length();
	}

	public int badLengthFunctionInstance(int str) {
		return str;
	}
}

class BasicUnaryOperatorReferenceUtility {
	public String coolUpperCaseFunctionInstance(String str) {
		return str.toUpperCase();
	}

	public int coolLengthFunctionInstance(String str) {
		return str.length();
	}

	public int badLengthFunctionInstance(int str) {
		return str;
	}
}
