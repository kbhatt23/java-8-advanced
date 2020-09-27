package ownfunctionalInterface;

import java.util.function.Consumer;

public class ConsunmerUSage {
public static void main(String[] args) {
	Consumer<String> c1 = (msg) -> System.out.println(msg);
	
	Consumer<String> c2 = (msg) -> System.out.println(msg.toUpperCase());
	
	c1.andThen(c2).accept("jai shree ram");
}
}
