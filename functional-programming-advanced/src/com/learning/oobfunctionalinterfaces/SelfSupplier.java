package com.learning.oobfunctionalinterfaces;

@FunctionalInterface
public interface SelfSupplier<T> {

	T supply();
	
	//no chainingnpossible, as inout is not possible in supplier
}
