package hust.soict.dsai.test.cart.CartTest;
import hust.soict.dsai.aims.cart.Cart.Cart; 
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, "George Lucas", 121);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f, "Ron Clements", 90);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("War of the Worlds", "Science Fiction", 15.00f, "Steven Spielberg", 116);
		cart.addMedia(dvd1); 
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
        cart.addMedia(dvd4);
		cart.print(); 		
		System.out.println("\n--- Testing SearchByID ---");
		cart.searchByID(3); 
		cart.searchByID(14);	
		System.out.println("\n--- Testing SearchByTitle ---");
		cart.searchByTitle("War");
		cart.searchByTitle("Doraemon");
        System.out.println("\n--- Testing Remove Media ---");
        cart.removeMedia(dvd1);
        cart.print();
	}			
}