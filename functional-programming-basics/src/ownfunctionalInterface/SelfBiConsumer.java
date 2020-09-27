package ownfunctionalInterface;

public interface SelfBiConsumer<T,S> {

	void accept(T t, S s);
	
	//chaining
	default SelfBiConsumer<T,S> andThen(SelfBiConsumer<T,S> another) {
		return (t,s) -> {
			accept(t, s);
			another.accept(t, s);
		};
	}
}
