package ownfunctionalInterface;

@FunctionalInterface
public interface SelfConsumer<T> {

	void accept(T t);
	
	//chaining method
	//making it default as it should be called on some object of this interface's subclass
	
	default SelfConsumer<T> andThen(SelfConsumer<T> anotherSelfConsumer) {
		//make a new consumer
		return (T t) -> {
			accept(t);
			anotherSelfConsumer.accept(t);
		};
	}
}
