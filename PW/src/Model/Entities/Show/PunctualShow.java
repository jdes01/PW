public class PunctualShow {
    
    private Date date; // single date


    public PunctualShow(String title, String cathegory, String description, Int locationCapacity, Date date){

        super(title, cathegory, description, locationCapacity);

        this.date = date;
    }

    public Date getDate(){ return this.date; }

    public void setDate(Date date){ this.date = date; }
}