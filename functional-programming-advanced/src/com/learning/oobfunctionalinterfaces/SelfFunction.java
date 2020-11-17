package com.learning.oobfunctionalinterfaces;

import java.util.Objects;

@FunctionalInterface
public interface SelfFunction<T,R> {

	R apply(T t);
	
	//chaining
	//create bigger function from smaller funbcation
	//output of first functions hud be input of second function
	
	default <S> SelfFunction<T, S> andThen(SelfFunction<R,S> otherFunction){
		Objects.requireNonNull(otherFunction);
		
		return t -> otherFunction.apply(apply(t));
	}
	
	//compose
	default <S> SelfFunction<S, R> compose(SelfFunction<S,T> otherFunction){
		Objects.requireNonNull(otherFunction);
		return s -> apply(otherFunction.apply(s));
		
	}
	
}
