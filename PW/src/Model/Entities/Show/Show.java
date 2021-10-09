public class Show {

    private String title;
    
    private String cathegory; // concierto, monologo, obra de teatro

    private String description;

    private Int capacity;

    private ArrayList<LocationAndAvailableTickets> locationsAndAvailableTickets = new LocationAndAvailableTickets<>();

    private ArrayList<Review> showReviews = new ArrayList<Review>();


    public Show(String title, String cathegory, String description, Int capacity){

        this.title        = title;
        this.cathegory    = cathegory;
        this.description  = description;
        this.capacity     = capacity;
    }  
    

    public String getTitle(){ return this.title; }
	
	public String getCathegory(){ return this.cathegory; }
	
	public String getDescription(){ return this.description; }

    public Int getCapacity(){ return this.capacity; }

    public ArrayList<LocationAndAvailableTickets> getLocationAndAvailableTickets(){ return locationsAndAvailableTickets; }
	
	
	
	public void setTitle(String title){ this.title = title; }
	
	public void setCathegory(String cathegory){ this.cathegory = cathegory; }
	
	public void setDescription(String description){ this.description = description; }

    public void setCapacity(Int capacity){ this.capacity = capacity; }

    public void addLocation(String location){

        LocationAndAvailableTickets locationAndAbailableTickets = new LocationAndAvailableTickets(location, this.capacity);

        this.locationsAndAvailableTickets.add(locationAndAbailableTickets);
    }

    public void addShowReview(Review review){

        this.showReviews.add(review);
    }
      
}
