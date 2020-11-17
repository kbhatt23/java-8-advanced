package streamusage;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class StreamVsIterator {
public static void main(String[] args) {
	List<String> names = Arrays.asList("sita-ram","ramduta-hanuman","hanumanbhakt-kannu","fake-name");
	
	learnIterator(names);
	
	//streams can be used only once -> if any operation is used,
	//and again in same onject we try to call operation it gives unsupportedoperationexception
	Stream<String> stream = names.stream();
	stream.filter(a -> {System.out.println("filtering item ");return a.contains("ram");})
		.forEach(System.out::println);
	;
	
	//stream.filter(a -> a.contains("hanuman"));
	
	//streams do not hold dat
	
}

private static void learnIterator(List<String> names) {
	//iterator once iterated till end will put cursor at the end and hence wont come again
	ListIterator<String> iterator = names.listIterator();
	while(iterator.hasNext()) {
		System.out.println("iterator found element "+iterator.next());
	}
	
	//curor is at the end and hence no next element present
	while(iterator.hasNext()) {
		System.out.println("iterator found again element "+iterator.next());
	}
	
	//lets reverse it
	System.out.println("======lets reverse it============");
	while(iterator.hasPrevious()) {
		System.out.println("reverse iterator found "+iterator.previous());
	}
	
	//cursor is at the begining , so can not go more previoys
	while(iterator.hasPrevious()) {
		System.out.println("reverse iterator again found "+iterator.previous());
	}
}
}
