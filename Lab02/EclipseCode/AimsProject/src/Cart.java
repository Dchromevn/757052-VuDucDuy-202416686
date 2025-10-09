public class Cart {
	public static final int MAX_NUMBERS_ORDERED =20;
	private DigitalVideoDisc itemsOrdered[]=
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered =0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc){
		if (qtyOrdered==MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}else {
		    itemsOrdered[qtyOrdered] = disc;
		    System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
		    qtyOrdered ++;
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc){
		boolean checkdisc=false;
		for (int i=0; i<=qtyOrdered;i++) {
			if(itemsOrdered[i]==disc) {
				checkdisc= true;
				for (int j=i;j<=qtyOrdered-1;j++) {
					itemsOrdered[j]=itemsOrdered[j+1];
					qtyOrdered--;
					System.out.println("We have removed the disk"+disc.getTitle()+"from cart");
				}
				break;
			}
		}
		if (!checkdisc) System.out.println("The disk is not found in the cart");
	}
}
