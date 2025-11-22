package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable { 
    public DigitalVideoDisc(String title) { 
    	super(title); 
    	}
    public DigitalVideoDisc(String title, String category, float cost) { 
    	super(title, category, cost); 
    	}
    public DigitalVideoDisc(String title, String category, float cost, String director) {
        super(title, category, cost, director, 0); 
    }

    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        super(title, category, cost, director, length);
    }
    @Override
    public void play() {
    	System.out.println("Playing DVD: "+ this.getTitle());
    	System.out.println("DVD length: "+ this.getLength());
    }
    
}