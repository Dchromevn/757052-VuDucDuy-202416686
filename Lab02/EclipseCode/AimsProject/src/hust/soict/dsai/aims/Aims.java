package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store.Store;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class Aims { 
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeStore(); 
        
        while (true) {
            try {
                showMenu(); 
                int choice = scanner.nextInt();
                scanner.nextLine();
                handleMainMenu(choice);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    public static void initializeStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        store.addMedia(dvd1);
        Book book1 = new Book("The Lord of the Rings", "Fantasy", 25.50f);
        book1.addAuthor("J.R.R. Tolkien");
        store.addMedia(book1);
        CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", 15.00f, "George Martin", 47, "The Beatles");
        cd1.addTrack(new Track("Come Together", 4));
        cd1.addTrack(new Track("Something", 3));
        store.addMedia(cd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f, "Ron Clements", 90);
        store.addMedia(dvd2);
        Book book2 = new Book("Java Core", "Programming", 35.00f);
        store.addMedia(book2);
    }
    public static void showMenu() { 
        System.out.println("\n--- AIMS: An Internet Media Store ---");
        System.out.println("-------------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------");
        System.out.print("Please choose a number (0-1-2-3): ");
    }
    public static void storeMenu() { 
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number (0-1-2-3-4): ");
    }
    public static void mediaDetailsMenu(Media media) { 
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }
   public static void cartMenu() { 
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number (0-1-2-3-4-5): ");
    }
    public static void handleMainMenu(int choice) {
        switch (choice) {
            case 1: viewStore(); break;
            case 2: updateStore(); break;
            case 3: seeCart(); break;
            case 0:
                System.out.println("Thank you for using AIMS. Goodbye!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }   
    public static void viewStore() {
        store.displayStore(); 
        
        while (true) {
            try {
                storeMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                if (choice == 0) return; 
                handleStoreMenu(choice);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }    
    public static void handleStoreMenu(int choice) {
        String title;
        Media foundMedia = null;     
        try {
            switch (choice) {
                case 1: 
                    System.out.print("Enter Media title: ");
                    title = scanner.nextLine();
                    foundMedia = store.findMediaByTitle(title);
                    if (foundMedia != null) {
                        System.out.println("Media Details:\n" + foundMedia.toString());
                        handleMediaDetailsMenu(foundMedia); 
                    } else {
                        System.out.println("Media not found with this title.");
                    }
                    break;
                case 2: 
                    System.out.print("Enter Media title to add: ");
                    title = scanner.nextLine();
                    foundMedia = store.findMediaByTitle(title);
                    if (foundMedia != null) {
                        cart.addMedia(foundMedia);
                    } else {
                        System.out.println("Media not found with this title.");
                    }
                    break;
               case 3: 
                    System.out.print("Enter Media title to Play: ");
                    title = scanner.nextLine();
                    foundMedia = store.findMediaByTitle(title);
                    if (foundMedia != null) {
                        if (foundMedia instanceof Playable) {
                            ((Playable) foundMedia).play();
                        } else {
                            System.out.println("This Media is not playable.");
                        }
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 4: 
                    seeCart();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during processing: " + e.getMessage());
        }
    }   
    public static void handleMediaDetailsMenu(Media media) {
        mediaDetailsMenu(media);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1: 
                cart.addMedia(media);
                break;
            case 2: 
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("Invalid Play choice or Media is not Playable.");
                }
                break;
            case 0: 
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    public static void seeCart() {
        cart.print();
        
        while (true) {
            try {
                cartMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                if (choice == 0) return;
                handleCartMenu(choice);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    public static void handleCartMenu(int choice) {
        try {
            switch (choice) {
                case 1: filterCart(); break;
                case 2: sortCart(); break; 
                case 3: removeMediaFromCart(); break;
                case 4: playMediaInCart(); break;
               case 5: placeOrder(); return;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while processing the cart: " + e.getMessage());
        }
    }
    public static void updateStore() {
        System.out.println("Update Store functionality (Add/Remove) is not fully implemented.");
    }  
    public static void filterCart() {
        System.out.println("\n--- Filter Options ---");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.print("Choose filter method (1-2): ");
        int filterChoice = scanner.nextInt();
        scanner.nextLine();    
        switch (filterChoice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.filterMedias(id);
                break;
            case 2:
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                cart.filterMedias(title);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }   
    public static void sortCart() {
        System.out.println("\n--- Sorting Options ---");
        System.out.println("1. Sort by Title (then Cost)");
        System.out.println("2. Sort by Cost (then Title)");
        System.out.print("Please choose a number (1-2): ");       
        int sortChoice = scanner.nextInt();
        scanner.nextLine();      
        ArrayList<Media> itemsToSort = cart.getItemsOrdered();     
        if (itemsToSort.isEmpty()) {
            System.out.println("Cart is empty. Nothing to sort.");
            return;
        }    
        switch (sortChoice) {
            case 1:
                Collections.sort(itemsToSort, Media.COMPARE_BY_TITLE_COST);
                System.out.println("Cart successfully sorted by Title, Cost.");
                break;
            case 2:
                Collections.sort(itemsToSort, Media.COMPARE_BY_COST_TITLE);
                System.out.println("Cart successfully sorted by Cost, Title.");
                break;
            default:
                System.out.println("Invalid sorting option.");
        }   
        cart.print(); 
    }
    public static void removeMediaFromCart() {
        System.out.print("Enter Media title to remove: ");
        String title = scanner.nextLine();
        Media mediaToRemove = cart.findMediaByTitle(title);
        
        if (mediaToRemove != null) {
            cart.removeMedia(mediaToRemove);
        } else {
            System.out.println("Media not found in the cart.");
        }
    }
    public static void playMediaInCart() {
        System.out.print("Enter Media title to Play: ");
        String title = scanner.nextLine();
        Media foundMedia = cart.findMediaByTitle(title);      
        if (foundMedia != null) {
            if (foundMedia instanceof Playable) {
                ((Playable) foundMedia).play();
            } else {
                System.out.println("Media not found or is not Playable.");
            }
        } else {
            System.out.println("Media not found in the cart.");
        }
    }
    public static void placeOrder() {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return;
        }       
        System.out.println("\n--- ORDER CREATED ---");
        System.out.println("Total Cost: " + cart.totalCost() + " $");
        System.out.println("Order successfully created! Your cart has been emptied.");        
        cart.placeOrder();
    }
}