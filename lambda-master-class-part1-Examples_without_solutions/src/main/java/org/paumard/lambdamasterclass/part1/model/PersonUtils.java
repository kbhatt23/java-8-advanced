package org.paumard.lambdamasterclass.part1.model;

import java.util.Arrays;
import java.util.List;

public class PersonUtils {

	public static List<Person> listPersons(){
		Person p1 = new Person("langa", 23);
		Person p2 = new Person("kanga", 21);
		Person p3 = new Person("anga", 11);
		Person p4 = new Person("bhanga", 66);
		Person p5 = new Person("bhanga", 99);
		return Arrays.asList(p1,p2,p3,p4,p5);
	}
}
