package hust.soict.hedspi.aims.media;
import java.util.*;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public Book() {
		// TODO Auto-generated constructor stub
		super.setType("Book");
	}
	
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
		super.setType("Book");
	}

	public boolean addAuthor(String name) {
		if(!authors.contains(name)) {
			authors.add(name);
			return true;
		}
		return false;
	}
	
	public boolean removeAuthor(String name) {
		if(authors.contains(name)) {
			authors.remove(name);
			return true;
		}
		return false;
	}
	
	public String toString() {
		String str = "Book: " + this.getTitle() + " - Category: " + this.getCategory() + " - Author(s): ";
		for(String s: authors) str = str + s + ", ";
		str = str + "Cost: " + this.getCost();
		return str;
	}
	
	
	
	
	
	
	
	
	
	
}
