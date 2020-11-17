package streamusage;

import java.util.List;
import java.util.stream.IntStream;

import data.Book;
import data.BookProvider;

public class PrimitiveStreams {
public static void main(String[] args) {
	List<Book> findBooks = BookProvider.findBooks();
	
	double average1 = findBooks.stream()
			 .mapToDouble(Book::getRating)
			 .average().orElse(0d);
	System.out.println(average1);
	IntStream.of(1,2,3,4,5)
			.mapToObj(number -> new Animal(number, "jai shree ram : "+number))
			.forEach(System.out::println);
			
			
}

static class Animal{
	private int id;
	private String name;
	public Animal(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + "]";
	}
	
	
}
}
