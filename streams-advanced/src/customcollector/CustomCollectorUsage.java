package customcollector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;

public class CustomCollectorUsage {
public static void main(String[] args) {
	
	Collector<String, List<String>, List<String>>
		customCollector = 
			Collector.of(ArrayList::new,
					
					(items,item) -> items.add(item), (items1,items2) -> {items1.addAll(items2); return items1;});


	List<String> names = Arrays.asList("sita-ram","sita-rama","fake-human","ramaduta-hanuman","ramaduta-hanuman");
	List<String> collect = names.stream()
		.filter(w -> w.contains("sita") || w.contains("ram"))
		.collect(customCollector);
	
	System.out.println(collect);
	
	Function<List<String>, List<String>> finisher = list -> {
		Collections.sort(list);
		return list;
	};
	
	Collector<String, List<String>, List<String>> sortedCollector
		= Collector.of(ArrayList::new,
				(items,item) -> items.add(item),
				(items1,items2) -> {items1.addAll(items2); return items1;},list -> {
					Collections.sort(list);
					return list;
				} );
	
	List<String> sortedCollect = names.stream()
			.filter(w -> w.contains("sita") || w.contains("ram"))
			.collect(sortedCollector);
	System.out.println(sortedCollect);
	
	//to remove dupilcates lets create set
	
	Collector<String, List<String>, Set<String>> uniqueCollector
	= Collector.of(ArrayList::new,
			(items,item) -> items.add(item),
			(items1,items2) -> {items1.addAll(items2); return items1;},HashSet:: new , Collector.Characteristics.UNORDERED);
	
	Set<String> uniqueSet = names.stream()
			.filter(w -> w.contains("sita") || w.contains("ram"))
			.collect(uniqueCollector);
	System.out.println(uniqueSet);
}
}
