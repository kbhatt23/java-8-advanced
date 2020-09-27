package ownfunctionalInterface;

public interface SelfPredicate<T> {

	boolean test(T t);
	
	default SelfPredicate<T> and(SelfPredicate<T> other){
		return (T t) -> test(t) && other.test(t); 
	}
	
	default SelfPredicate<T> or(SelfPredicate<T> other){
		return (T t) -> test(t) || other.test(t); 
	}
	
	default SelfPredicate<T> not(){
		return (T t) -> !test(t) ; 
	}
}
