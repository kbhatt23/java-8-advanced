package com.learning.lambdas;

public class AnonymousClassWay {
public static void main(String[] args) {
	MyFunctionalInterface type1 = new MyFunctionalInterface() {
		@Override
		public void apply() {
			System.out.println("jai shree ram");
		}
	};
	
	type1.apply();
	
	
	MyFunctionalInterface type2 = new MyFunctionalInterface() {
		@Override
		public void apply() {
			System.out.println("jai radhe krishna");
		}
	};
	type2.apply();
}
}
