package util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamUtil {

	public static <T> List<T> paginate(List<T> items, int pageNumber, int sizePerPage){
		Objects.requireNonNull(items);
		int skip = pageNumber *sizePerPage;
		return items.stream()
			 .skip(skip)
			 .limit(sizePerPage)
			 .collect(Collectors.toList());
		
	}
}
