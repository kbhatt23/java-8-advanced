package org.paumard.lambdamasterclass.part1.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

public interface SelfComparator<T> {

	int compare(T t1, T t2);

	// bigger comparator to first compare with niitial property then another one
	default SelfComparator<T> thenComparing(SelfComparator<T> another) {

		return (t1, t2) -> {
			int compareCurrent = compare(t1, t2);
			return compareCurrent == 0 ? another.compare(t1, t2) : compareCurrent;

		};

	}

	static <T, R extends Comparable<R>> SelfComparator<T> comparing(Function<T, R> transformer) {
		return (T t1, T t2) ->
			transformer.apply(t1).compareTo(transformer.apply(t2));
	}
	
	static <T> Comparator<T> nullsLast(Comparator<T> cmp){
		return (T t1, T t2) ->{
			if(t1 == null) {
				return 1;
			}
			if(t2 == null) {
				return -1;
			}
			return cmp.compare(t1, t2);
		};
	}
	
	default  Comparator<T> reverse(){
		return (T t1, T t2) ->{
			return compare(t2, t1);
		};
	}
	
}
