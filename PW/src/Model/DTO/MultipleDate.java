package Model.DTO;

import java.util.ArrayList;
import java.util.Date;

public class MultipleDate implements DateInterface {

    private ArrayList<Date> dateList = new ArrayList<Date>();

    public MultipleDate(Date newDate) {
        this.dateList.add(newDate);
    }

    public ArrayList<Date> getDates(){ return this.dateList; }

    public void addDate(Date newDate){ this.dateList.add(newDate); }
    
}