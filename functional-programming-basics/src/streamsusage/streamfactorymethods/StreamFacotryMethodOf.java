package streamsusage.streamfactorymethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFacotryMethodOf {
public static void main(String[] args) {
	List<String> players  = Arrays.asList("messi", "pele","maradona","zidane","ronaldo");
	Stream<List<String>> streamUsingOf = Stream.of(players);
	
	streamUsingOf.forEach(System.out::println);
	//of method is used to egenrate finite elelmtns stream
	Stream<String> betterStreamOf = Stream.of("messi", "pele","maradona","zidane","ronaldo");
	
	betterStreamOf.parallel().sequential().forEach(System.out::println);
}
}
