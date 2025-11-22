package hust.soict.dsai.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0; 
    public Media() {
        nbMedia++;
        this.id = nbMedia;
    }
    public Media(String title) {
        this();
        this.title = title;
        this.category = "Unknown";
        this.cost = 0.0f;
    }
    public Media(String title, String category, float cost) {
        this();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public int getId() { 
    	return id; 
    	}
    public String getTitle() { 
    	return title; 
    	}
    public String getCategory() { 
    	return category; 
    	}
    public float getCost() { 
    	return cost; 
    	}
    public void setTitle(String title) { 
    	this.title = title; 
    	}
    public void setCategory(String category) { 
    	this.category = category; 
    	}
    public void setCost(float cost) { 
    	this.cost = cost; 
    	}
    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}