package data;

import java.util.ArrayList;
import java.util.List;

public class BookProvider {

	public static List<Book> findBooks(){
		List<Book> list = new ArrayList<>();

		list.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		list.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		list.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		list.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));
		return list;
	}
}
