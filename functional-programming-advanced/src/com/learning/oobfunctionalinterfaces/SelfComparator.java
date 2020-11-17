package com.learning.oobfunctionalinterfaces;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface SelfComparator<T> {

	int compare(T a, T b);
	
	static <T,R extends Comparable<R>> SelfComparator<T> comparing(Function<T, R> function){
		Objects.requireNonNull(function);
		return (a,b) -> function.apply(a).compareTo(function.apply(b));
	}
	
	default <R extends Comparable<R>> SelfComparator<T> thenComparing(Function<T, R> function){
		Objects.requireNonNull(function);
		
		return (a,b) -> { int compareResult = compare(a, b); return compareResult == 0 ? function.apply(a).compareTo(function.apply(b)) : compareResult;};
	}
}
