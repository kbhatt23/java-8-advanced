package ownfunctionalInterface;

public interface SelfBiPredicate<T, S> {

	boolean test(T t, S s);

	default SelfBiPredicate<T, S> and(SelfBiPredicate<T, S> another) {
		return (t, s) -> test(t, s) && another.test(t, s);
	}
	default SelfBiPredicate<T, S> or(SelfBiPredicate<T, S> another) {
		return (t, s) -> test(t, s) || another.test(t, s);
	}
	
	default SelfBiPredicate<T, S> not() {
		return (t, s) -> !test(t, s);
	}

}
