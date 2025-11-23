package hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED =20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public void addMedia(Media media) {
		if (itemsOrdered.size()<MAX_NUMBERS_ORDERED) {
			if (!itemsOrdered.contains(media)) {
				itemsOrdered.add(media);
				System.out.println("Media "+media.getTitle()+" has been added to cart");
			}else {
				System.out.println("This media is already in the cart");
			}
		}
	}
	public void removeMedia(Media media) {
	    if (itemsOrdered.remove(media)) { 
	        System.out.println("Media '" + media.getTitle() + "' has been removed from the cart.");
	    } else {
	        System.out.println("ERROR: Media '" + media.getTitle() + "' is not found in the cart.");
	    }
	}
	public void print() {
	    System.out.println("***************CART***************");
	    System.out.println("Ordered Items:");
	    for (int i = 0; i < itemsOrdered.size(); i++) {
	        Media media = itemsOrdered.get(i);
	        System.out.println(i + 1 + ". " + media.toString());
	    }
	    System.out.println("Total cost: " + totalCost() + " $");
	    System.out.println("**********************************");
	}
	public float totalCost() {
		float totalCost=0.0f;
		for (Media media:itemsOrdered) {
			totalCost+=media.getCost();
		}
		return totalCost;
	}
	public void searchByID(int id) {
	    boolean found = false;
	    for (Media media : itemsOrdered) {
	        if (media.getId() == id) {
	            System.out.println("Item found:");
	            System.out.println(media.toString());
	            found = true;
	            break; 
	        }
	    }	    
	    if (!found) {
	        System.out.println("There is no item with ID: " + id + " in the current cart.");
	    }
	}
	public void searchByTitle(String title) {
	    boolean found = false;	    
	    System.out.println("Matching items found:");

	    for (Media media : itemsOrdered) {
	        if (media.isMatch(title)) { 
	            System.out.println(media.toString());
	            found = true;
	        }
	    }	    
	    if (!found) {
	        System.out.println("There is no item with title containing: '" + title + "' in the current cart.");
	    }
	}
}
