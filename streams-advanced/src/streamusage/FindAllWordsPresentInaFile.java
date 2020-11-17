package streamusage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindAllWordsPresentInaFile {
public static void main(String[] args) {
	Path path= Paths.get("C:\\Kanishk\\learning\\java-8\\java-8-advanced\\streams-advanced\\filetoread.txt");
	
	try {
		List<String> allLines = Files.readAllLines(path);
		Set<String> words = allLines.stream()
			    .map(line -> line.split(" "))//get all the words in single line -> Stream<String[]>
			    .flatMap(Arrays::stream)
			    .distinct()
			    .collect(Collectors.toSet());
		System.out.println(words);
		
		System.out.println("lets count words freequency");
		Map<String, Long> wordsCount = allLines.stream()
			    .map(line -> line.split(" "))//get all the words in single line -> Stream<String[]>
			    .flatMap(Arrays::stream)
			    .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()));
		System.out.println(wordsCount);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
