package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("Media " + media.getTitle() + " has been added to cart");
            } else {
                System.out.println("This media is already in the cart");
            }
        } else {
            System.out.println("ERROR: The cart is full. Cannot add media.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) { 
            System.out.println("Media '" + media.getTitle() + "' has been removed from the cart.");
        } else {
            System.out.println("ERROR: Media '" + media.getTitle() + "' is not found in the cart.");
        }
    }

    public float totalCost() {
        float totalCost = 0.0f;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
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
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) { 
                return media; 
            }
        }
        return null; 
    }
    public void filterMedias(int id) {
        boolean found = false;
        System.out.println("\n--- Items Matching ID: " + id + " ---");
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with ID: " + id + ".");
        }
    }
    public void filterMedias(String title) {
        boolean found = false;
        System.out.println("\n--- Items Matching Title: '" + title + "' ---");
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) { 
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item found with title containing: '" + title + "'.");
        }
    }
    public void placeOrder() {
        itemsOrdered.clear();
    }
    public int getQtyOrdered() {
        return itemsOrdered.size();
    }
}