package org.paumard.lambdamasterclass.part1.util;

@FunctionalInterface
public interface SelfPredicate<T> {

	boolean test(T t);
	
	
	default SelfPredicate<T> xor(SelfPredicate<T> another){
		return t -> {
			if(this.test(t) && another.test(t)) {
				return false;
			}
			return test(t) || another.test(t);
		};
	}
}
