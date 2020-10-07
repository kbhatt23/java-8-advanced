package org.paumard.lambdamasterclass.part1.util;

import java.util.Collections;
import java.util.List;

import org.paumard.lambdamasterclass.part1.model.Person;
import org.paumard.lambdamasterclass.part1.model.PersonUtils;

public class SelfComparatorUsage {
public static void main(String[] args) {
	SelfComparator<Person> c= SelfComparator.comparing(Person::getLastName)
		.thenComparing(SelfComparator.comparing(Person::getAge));
	;
	
	List<Person> listPersons = PersonUtils.listPersons();
	
	for(int i = 0 ; i<listPersons.size()-1 ; i++) {
		Person currnet = listPersons.get(i);
		Person next = listPersons.get(i+1);
		System.out.println(c.compare(currnet, next));
	}
} 

}
