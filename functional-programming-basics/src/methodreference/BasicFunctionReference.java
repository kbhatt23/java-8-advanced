package methodreference;

import java.util.function.Function;

public class BasicFunctionReference {
	private static Function<String, String> upperCaseFunction = BasicFunctionReference::coolUpperCaseFunction;

	private static Function<String, Integer> lengthFunction = BasicFunctionReference::coolLengthFunction;

	private static Function<Integer, Integer> badLengthFunction = BasicFunctionReference::badLengthFunction;
	
	private Utility utility = new Utility();

	public static void main(String[] args) {
		BasicFunctionReference obj = new BasicFunctionReference();
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
		Function<String, String> upperInstanceCaseFunction = this::coolUpperCaseFunctionInstance;
		Function<String, Integer> lengthFunction = this::coolLengthFunctionInstance;
		Function<Integer, Integer> badLengthFunction = this::badLengthFunctionInstance;
		System.out.println(upperInstanceCaseFunction.apply("jai shree ram"));
		System.out.println(lengthFunction.apply("jai shree ram"));
		System.out.println(badLengthFunction.apply(23));
	}
	
	public void typeThree() {
		Function<String, String> upperInstanceCaseFunction = utility::coolUpperCaseFunctionInstance;
		Function<String, Integer> lengthFunction = utility::coolLengthFunctionInstance;
		Function<Integer, Integer> badLengthFunction = utility::badLengthFunctionInstance;
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

class Utility {
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
