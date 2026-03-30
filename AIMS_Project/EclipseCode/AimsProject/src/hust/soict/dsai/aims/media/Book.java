package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book() { 
    	super(); 
    	}
    public Book(String title) { 
    	super(title); 
    	}
    public Book(String title, String category, float cost) { 
    	super(title, category, cost); 
    	}
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' added successfully.");
        } else {
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' removed successfully.");
        } else {
            System.out.println("Author '" + authorName + "' not found in the list.");
        }
    }
    public List<String> getAuthors() { 
    	return authors; 
    	}
    @Override
    public String toString() {
        String authorString = String.join(", ", getAuthors()); // Nối các tác giả thành một chuỗi
        return "Book - [" + getTitle() + "] - [" + getCategory() + 
               "] - [Authors: " + authorString + "]: " + getCost() + " $";
    }
}