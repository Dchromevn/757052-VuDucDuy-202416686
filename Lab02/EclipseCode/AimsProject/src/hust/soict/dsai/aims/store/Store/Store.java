package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {} 

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
             System.out.println("ERROR: Media '" + media.getTitle() + "' is already in the store.");
             return;
        }
        itemsInStore.add(media);
        System.out.println("Media '" + media.getTitle() + "' has been added to the store.");
    }
    
    // Phương thức cần cho Menu Store (tùy chọn 2 trong Menu Chính)
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("ERROR: Media '" + media.getTitle() + "' is not found in the store.");
        }
    }

    // Phương thức cần cho Menu Store (tìm kiếm media theo Title)
    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) { 
                return media; 
            }
        }
        return null;
    }
    
    // Phương thức cần cho Menu Store (tùy chọn 1 trong Menu Chính)
    public void displayStore() {
        System.out.println("\n***************STORE ITEMS***************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
            System.out.println("*****************************************");
            return;
        }
        
        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            // Sử dụng toString() đã override trong các lớp con
            System.out.println((i + 1) + ". ID: " + media.getId() + " - " + media.toString());
        }
        System.out.println("*****************************************");
    }
}