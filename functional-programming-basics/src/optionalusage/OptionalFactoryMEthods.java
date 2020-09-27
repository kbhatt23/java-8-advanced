package optionalusage;

import java.util.Optional;

public class OptionalFactoryMEthods {
	public static void main(String[] args) {
		 //Optional<String> optinalStr = Optional.empty();

		// Optional<String> optinalStr = Optional.of("jai shree ram");
		// Optional<String> optinalStr = Optional.of(null);

		//Optional<String> optinalStr = Optional.ofNullable(null);
		Optional<String> optinalStr = Optional.ofNullable("jai shree ram");
		if (optinalStr.isPresent()) {
			System.out.println(optinalStr.get());
		} else {
			System.out.println("str optional is empty");
		}
	}
}
