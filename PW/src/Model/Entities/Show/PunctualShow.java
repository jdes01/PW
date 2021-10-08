public class PunctualShow {
    
    private String date; // single date


    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, String date){

        this.title            = title;
        this.cathegory        = cathegory;
        this.description      = description;
        this.locationCapacity = locationCapacity;

        this.date = date;
    }

    public String getDate(){ return this.date; }

    public void setDate(String date){ this.date = date; }
}