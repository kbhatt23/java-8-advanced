package streamusage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatmapUSage {
public static void main(String[] args) {
	Stream<String> a = Stream.of("sita-ram","radhe-krishna");
	
	Stream<String> b = Stream.of("uma-shankar","ramduta-hanuman");
	
	Stream<Stream<String>> twoDStream = Stream.of(a,b);
	
	List<String> names = twoDStream.flatMap(Function.identity())
	.collect(Collectors.toList());
	System.out.println(names);
	
	List<List<String>> stringNames = Arrays.asList(Arrays.asList("sita-ram","radhe-krishna"), Arrays.asList("uma-shankar","ramduta-hanuman"));
	List<String> nameStr = stringNames.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
	System.out.println(nameStr);
}
}
