package Model.DTO;

import java.io.Serializable;
import java.util.Date;

public class SingleDate implements DateInterface, Serializable {

    private Date date;

    public SingleDate(Date newDate) {
        this.date = newDate;
    }

    public Date getDate(){ return this.date; }

    public void setDate(Date newDate){ this.date = newDate; }
    
}
