public class PunctualShow {
    
    private String date; // single date


    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, String date){

        super(title, cathegory, description, locationCapacity);

        this.date = date;
    }

    public String getDate(){ return this.date; }

    public void setDate(String date){ this.date = date; }
}