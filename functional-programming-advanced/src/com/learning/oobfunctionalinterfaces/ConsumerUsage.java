package com.learning.oobfunctionalinterfaces;

public class ConsumerUsage {
public static void main(String[] args) {
	SelfConsumer<String> consumer1 = str -> System.out.println("jai shree ram says "+str);
	
	SelfConsumer<String> consumer2 = str -> System.out.println("jai shree ram says "+str.toUpperCase());
	
	SelfConsumer<String> consumer3 = str -> System.out.println("jai shree ram says everyone but lakshmi narayan is best says "+str.toUpperCase());
	
	String str = "hanuman bhaGat kannu";
	consumer1.consume(str);
	consumer2.consume(str);
	
	System.out.println("======");
	consumer1
		.andThen(consumer2)
		.andThen(consumer3)
		.consume(str);
	
	System.out.println("======");
	
	consumer1.after(consumer2).consume(str);
	System.out.println("--------=-fail fast check-====================");
	
	//SelfConsumer<String> buildChain = consumer1.andThen(null);
	//buildChain.consume(str);
}
}
