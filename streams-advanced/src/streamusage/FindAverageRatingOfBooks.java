package streamusage;

import data.Book;
import data.BookProvider;

public class FindAverageRatingOfBooks {
public static void main(String[] args) {
	double averageRatings = BookProvider.findBooks()
		        .stream()
		        //.filter(book -> book.getRating() > 5)
		        .mapToDouble(Book::getRating)
		        .average()
		        .orElseThrow(() -> new RuntimeException("No book found"));
		        //.orElse(-1)
		        ;
		        
		        System.out.println(averageRatings);
		        
		       
}
}
