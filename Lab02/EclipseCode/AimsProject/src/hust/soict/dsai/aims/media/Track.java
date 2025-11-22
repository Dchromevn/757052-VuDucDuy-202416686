package hust.soict.dsai.aims.media;
public class Track  {
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }   
    public String getTitle() { return title; }
    public int getLength() { return length; }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Track)) return false;
        
        Track track = (Track) o;
        return this.length == track.length && 
               this.title.equals(track.title); 
    }
}