public class Cart {
	public static final int MAX_NUMBERS_ORDERED =20;
	private DigitalVideoDisc itemsOrdered[]=
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered =0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc){
		if (qtyOrdered==MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		}else {
		    itemsOrdered[qtyOrdered] = disc;
		    System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
		    qtyOrdered ++;
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc){
		boolean checkdisc=false;
		for (int i=0; i<qtyOrdered;i++) {
			if(itemsOrdered[i]==disc) {
				checkdisc= true;
				for (int j=i;j<=qtyOrdered-1;j++) {
					itemsOrdered[j]=itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered - 1] = null; 
		        qtyOrdered--; 
		        System.out.println("We have removed the disk"+disc.getTitle()+"from cart");
				break;
			}
		}
		if (!checkdisc) System.out.println("The disk is not found in the cart");
	}
	public float totalCost() {
	    float total = 0;
	    for (int i = 0; i < qtyOrdered; i++) {
	        total += itemsOrdered[i].getCost();
	    }
	    return total;
	}
	public int getQtyOrdered() {
        return qtyOrdered;
    }
    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	addDigitalVideoDisc(dvd1);
    	addDigitalVideoDisc(dvd2);
    	System.out.println("Two dvds have been added to the cart");
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    	for (DigitalVideoDisc disc: dvdList) {
    		addDigitalVideoDisc(disc);
    	}
    	System.out.println("A list of DVDs has been added to the cart");
    }
    public void print() {
    	System.out.println("The list of the DVDs in the cart");
    	for (int i=0;i<qtyOrdered;i++) {
    		System.out.println(itemsOrdered[i].toString());
    	}
    	System.out.println("Total cost is: "+totalCost());
    }
}
