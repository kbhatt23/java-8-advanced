package ownfunctionalInterface;
@FunctionalInterface
public interface SelfFunction<T,R> {

	R apply(T t);
	
	default <S> SelfFunction<T, S> andThen(SelfFunction<R,S> anotherfunction){
	return (T t) ->
		 anotherfunction.apply(apply(t));
	}
	
	default <S> SelfFunction<S, R> compose(SelfFunction<S,T> before){
		return (S s) ->
			 apply(before.apply(s));
		}
}
