package methodreference;

import java.util.function.Function;
import java.util.function.UnaryOperator;

//this calss uses self contained method in input of function and bifuncitons and its subtypes
//rules
// the inpout of java.util.function(any) should be the class where the methodis present
//the method have no oargumen
//the return type of arguemnt is smae as that of java.util.funciton
public class SelfContainedMethodReference {
	private static Function<String, String> toUppercasefun = String::toUpperCase;
	
	private static UnaryOperator<String> toUppercasefunUnary = String::toUpperCase;
	
	private static Function<String, Integer> stringLengthFun = String::length;

	public static void main(String[] args) {
		System.out.println(toUppercasefun.apply("jai shree ram"));
		System.out.println(stringLengthFun.apply("jai shree ram"));
		System.out.println(toUppercasefunUnary.apply("jai shree ram"));
	}
}
