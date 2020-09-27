package ownfunctionalInterface;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class UnaryOperatorUsage {
	public static void main(String[] args) {
		UnaryOperator<String> upperCaeOperator = s -> s.toUpperCase();
		Consumer<String> printStr = s -> System.out.println(s);
		printStr.accept(upperCaeOperator.apply("jai shree ram"));
	}

}
