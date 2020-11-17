package com.learning.oobfunctionalinterfaces;

import java.util.Objects;

@FunctionalInterface
public interface SelfConsumer<T> {

	void consume(T t);
	
	//chaning methods
	//same input goes to the chain of consumer one by one
	//make bigger consumeer from smaller consumer
	
	default SelfConsumer<T> andThen(SelfConsumer<T> otherConsumer){
		//this is making it fail fast
		//if we do not put this code to throw exception here, it will give null pointer exception while 
		//chain is built and while passing data to consume method it give error at runtime -> whihc is not fail fast
		Objects.requireNonNull(otherConsumer);
		return t -> {consume(t); otherConsumer.consume(t);};
	}
	
	default SelfConsumer<T> after(SelfConsumer<T> otherConsumer){
		Objects.requireNonNull(otherConsumer);
		return t -> { otherConsumer.consume(t);consume(t);};
	}
}
