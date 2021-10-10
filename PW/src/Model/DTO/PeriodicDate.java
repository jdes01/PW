package Model.DTO;

import java.util.Date;

public class PeriodicDate implements DateInterface{

    private Date date;

    public PeriodicDate(Date newDate){
        this.date = newDate;
    }

    public Date getDate(){ return this.date; }

    public void setDate(Date newDate){ this.date = newDate; }
    
}