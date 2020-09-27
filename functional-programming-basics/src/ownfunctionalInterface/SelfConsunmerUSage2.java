package ownfunctionalInterface;

import java.util.function.Consumer;

public class SelfConsunmerUSage2 {
public static void main(String[] args) {
	SelfConsumer<String> c1 = (msg) -> System.out.println(msg);
	
	SelfConsumer<String> c2 = (msg) -> System.out.println(msg.toUpperCase());
	
	SelfConsumer<String> c3 = (msg) -> System.out.println(msg.split(" "));
	
	c1.andThen(c2).andThen(c3).accept("jai shree ram");
}
}
