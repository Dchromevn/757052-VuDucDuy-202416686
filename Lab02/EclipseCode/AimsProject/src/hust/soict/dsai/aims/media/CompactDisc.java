package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();
    public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
        super(title, category, cost, director, length); 
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, director);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
    	return artist; 
    	}
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("You have add track: "+track.getTitle());
        }else {
        		System.out.println("There is an existing track name: "+track.getTitle()+". Can not add");
        }
    }
    public void removeTrack(Track track) {
        tracks.remove(track);
        System.out.println("You have removed track: "+track.getLength());
    }
    @Override
    public void play() {
    	System.out.println("Playing the CD: "+getTitle());
    	System.out.println("The Artist: "+getArtist());
    	System.out.println("CD length: "+ getLength());
    	System.out.println("---Playing Track---");
    	for (Track track : tracks) {
    		track.play();
    	}
    	System.out.println("Finish Playing CD");
    }
    @Override
    public String toString() {
        return "CD - [" + getTitle() + "] - [" + getCategory() + 
               "] - [Artist: " + getArtist() + "] - [Total Length: " + getLength() + 
               " mins]: " + getCost() + " $";
    }
}