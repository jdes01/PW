package Model.DTO;

import java.util.Date;

public class SingleDate implements DateInterface {

    private Date date;

    public SingleDate(Date newDate) {
        this.date = newDate;
    }

    public Date getDate(){ return this.date; }

    public void setDate(Date newDate){ this.date = newDate; }
    
}
