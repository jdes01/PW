public class SingleDate implements DateInterface {

    private Date date;

    public void SingleDate(Date newDate){

        this.date = newDate;
    }

    public Date getDate(){ return this.date; }

    public void setDate(Date newDate){ this.date = newDate; }
    
}
