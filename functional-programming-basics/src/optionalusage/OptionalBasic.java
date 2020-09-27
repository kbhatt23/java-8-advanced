package optionalusage;

import java.util.Optional;

import common.StudentDataBase;

public class OptionalBasic {
public static void main(String[] args) {

	//Optional<String> str = Optional.ofNullable(null);
	//Optional<String> str = Optional.empty();
	//above 2 optional behaves same way
	
	Optional<String> str = Optional.ofNullable("jai radha madhav"
			+ "");
	String a =str.map(s -> {
		System.out.println("starting transformation for "+s);
		return s.toUpperCase();
	}).orElse("khali hai be");
	System.out.println(a);
	
}
}
