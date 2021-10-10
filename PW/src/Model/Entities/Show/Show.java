package Model.Entities.Show;

import java.io.Serializable;
import java.util.ArrayList;

import Model.DTO.LocationAndAvailableTickets;
import Model.Entities.Review.Review;

public class Show implements Serializable {

    private String title;
    
    private String cathegory; // concierto, monologo, obra de teatro

    private String description;

    private Integer capacity;

    private ArrayList<LocationAndAvailableTickets> locationsAndAvailableTickets = new ArrayList<LocationAndAvailableTickets>();

    private ArrayList<Review> showReviews = new ArrayList<Review>();


    public Show(String title, String cathegory, String description, Integer capacity){

        this.title        = title;
        this.cathegory    = cathegory;
        this.description  = description;
        this.capacity     = capacity;
    }  
    

    public String getTitle(){ return this.title; }
	
	public String getCathegory(){ return this.cathegory; }
	
	public String getDescription(){ return this.description; }

    public Integer getCapacity(){ return this.capacity; }

    public ArrayList<LocationAndAvailableTickets> getLocationAndAvailableTickets(){ return locationsAndAvailableTickets; }
	
	
	
	public void setTitle(String title){ this.title = title; }
	
	public void setCathegory(String cathegory){ this.cathegory = cathegory; }
	
	public void setDescription(String description){ this.description = description; }

    public void setCapacity(Integer capacity){ this.capacity = capacity; }

    public void addLocation(String location){

        LocationAndAvailableTickets locationAndAbailableTickets = new LocationAndAvailableTickets(location, this.capacity);

        this.locationsAndAvailableTickets.add(locationAndAbailableTickets);
    }

    public void addShowReview(Review review){

        this.showReviews.add(review);
    }
      
}
