package hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc[] itemsInStore;
	private int qtyInStore=0;
	public Store(int maxCapacity) {
		itemsInStore= new DigitalVideoDisc[maxCapacity];
	}
	public void addDVD(DigitalVideoDisc disc) {
		if(qtyInStore< itemsInStore.length) {
			itemsInStore[qtyInStore]=disc;
			qtyInStore++;
			System.out.println("The DVD: "+disc.getTitle()+" has been add to store");
		}
		else {
			System.out.println("The Store is full of DVDs, cannot add anymore");
		}
	}
	public void removeDVD(DigitalVideoDisc disc) {
		boolean checkDVD=false;
		for (int i=0;i<qtyInStore;i++) {
			if(itemsInStore[i]==disc) {
				checkDVD=true;
				for (int j=i;j<qtyInStore-1;j++) {
					itemsInStore[j]=itemsInStore[j+1];
				}
				itemsInStore[qtyInStore - 1] = null;
				qtyInStore--;
				System.out.println("You have remove the DVD: "+disc.getTitle()+" from store");
				break;
			}
		}
		if(!checkDVD) {
			System.out.println("There is no DVD name: "+disc.getTitle()+" in the store");
		}
	}
}
