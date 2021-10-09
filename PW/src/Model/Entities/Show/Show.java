import MultipleDate;
import PeriodicDate;
import SingleDate;

public class Show {
    
    public Show(String title, String cathegory, String description, Int locationCapacity, SingleDate singleDate){

        this.title            = title;
        this.cathegory        = cathegory;
        this.description      = description;
        this.locationCapacity = locationCapacity;
            
        PunctualShow punctualShow = new PunctualShow(String title, String cathegory, String description, Int locationCapacity, SingleDate singleDate); 
    }

    public Show(String title, String cathegory, String description, Int locationCapacity, PeriodicDate periodicDate){

        this.title            = title;
        this.cathegory        = cathegory;
        this.description      = description;
        this.locationCapacity = locationCapacity;

        SeasonShow seasonShow = new SeasonShow(String title, String cathegory, String description, Int locationCapacity, PeriodicDate periodicDate); 
    }

    public Show(String title, String cathegory, String description, Int locationCapacity, MultipleDate multipleDate){

        this.title            = title;
        this.cathegory        = cathegory;
        this.description      = description;
        this.locationCapacity = locationCapacity;

        MultiplePassShow multiplePassShow = new MultiplePassShow(String title, String cathegory, String description, Int locationCapacity, MultipleDate multipleDate);
    }


    public String getTitle(){ return this.title; }
	
	public String getCathegory(){ return this.cathegory; }
	
	public String getDescription(){ return this.description; }

    public Int getLocationCapacity(){ return this.locationCapacity; }
	
	
	
	public void setTitle(String title){ this.title = title; }
	
	public void setCathegory(String cathegory){ this.cathegory = cathegory; }
	
	public void setDescription(String description){ this.description = description; }

    public void setLocationCapacity(Int locationCapacity){ this.locationCapacity = locationCapacity; }
}
