package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public Store() {
    } 
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
             System.out.println("ERROR: Media '" + media.getTitle() + "' is already in the store.");
             return;
        }       
        itemsInStore.add(media);
        System.out.println("Media '" + media.getTitle() + "' has been added to the store.");
    }
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) { 
            System.out.println("Media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("ERROR: Media '" + media.getTitle() + "' is not found in the store.");
        }
    }
}