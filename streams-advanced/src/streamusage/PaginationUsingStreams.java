package streamusage;

import java.util.Arrays;
import java.util.List;

import util.StreamUtil;

public class PaginationUsingStreams {
public static void main(String[] args) {
	List<String> names = Arrays.asList("sita-ram", "radhe shyam", "uma shankar" ,
				"lakshmi-narayan", "ramduta-hauman", "hanumanduta-kannu", "saraswati-brahma" 
			);
	
	List<String> paginate = StreamUtil.paginate(names, 3, 3);

	System.out.println(paginate);
}

}
