package com.learning.customspliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomFileSpliterator implements Spliterator<Employee>{

	private String firstName;
	private String lastName;
	private String ageString;
	
	private Spliterator<String> baseSpliterator;
	
	public CustomFileSpliterator(Spliterator<String> baseSpliterator) {
		this.baseSpliterator=baseSpliterator;
	}
	@Override
	public boolean tryAdvance(Consumer<? super Employee> action) {
		boolean firstNameSuccess = baseSpliterator.tryAdvance(firstName -> this.firstName = firstName);
		boolean flastNameSuccess =baseSpliterator.tryAdvance(lastName -> this.lastName = lastName);
		boolean ageSuccess =baseSpliterator.tryAdvance(ageString -> this.ageString = ageString);
		if(ageSuccess && firstNameSuccess && flastNameSuccess) {
			action.accept(new Employee(firstName, lastName, Integer.parseInt(ageString)));
			return true;
		}
		return false;
	}

	@Override
	public Spliterator<Employee> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		//size of proeprties for one employee is 3
		return baseSpliterator.estimateSize()/3;
	}

	@Override
	public int characteristics() {
		//we are copy9ing from list of string -> representing each line
		//so this spliterator shud also behave like a list
		return baseSpliterator.characteristics();
	}
	
	
}
