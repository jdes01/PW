import MultipleDate;
import PeriodicDate;
import SingleDate;

public class Show {
    
    private String title;
    
    private String cathegory; // concierto, monologo, obra de teatro

    private String description;

    private Int locationCapacity;


    public Show(String title, String cathegory, String description, Int locationCapacity, DateInterface date){

        if (date instanceof SingleDate){ 
            
            PunctualShow punctualShow = new PunctualShow(String title, String cathegory, String description, Int locationCapacity, DateInterface date); 
        
        } else if (date instanceof PeriodicDate) {

            SeasonShow seasonShow = new SeasonShow(String title, String cathegory, String description, Int locationCapacity, DateInterface date); 
        
        } else if (date instanceof MultipleDate) {

            MultiplePassShow multiplePassShow = new MultiplePassShow(String title, String cathegory, String description, Int locationCapacity, DateInterface date);
        }
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
