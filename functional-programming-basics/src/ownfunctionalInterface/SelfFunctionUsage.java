package ownfunctionalInterface;

import java.util.function.Function;

public class SelfFunctionUsage {
public static void main(String[] args) {
	SelfFunction<String, String> f1 = str -> str.split(" ")[0];
	
	SelfFunction<String, Integer> f2 = str -> str.length();
	
	System.out.println(f1.andThen(f2).apply("jai shree ram"));
	
	System.out.println(f2.compose(f1).apply("jai shree ram"));
	
}
}
