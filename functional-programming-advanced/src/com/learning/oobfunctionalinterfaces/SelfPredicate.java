package com.learning.oobfunctionalinterfaces;

import java.util.Objects;

@FunctionalInterface
public interface SelfPredicate<T> {

	boolean test(T t);
	
	//chaining methods
	
	//chaining means taking a smaller functional interface and creating a bigger interface
	
	// will be called on object of this interface implementer only
	
	default SelfPredicate<T> and(SelfPredicate<T> otherPredicate){
		Objects.requireNonNull(otherPredicate);
		return t -> test(t) && otherPredicate.test(t);
	}
	
	default SelfPredicate<T> or(SelfPredicate<T> otherPredicate){
		Objects.requireNonNull(otherPredicate);
		return t -> test(t) || otherPredicate.test(t);
	}
	
	default SelfPredicate<T> not(){
		return t -> !test(t);
	}
}
