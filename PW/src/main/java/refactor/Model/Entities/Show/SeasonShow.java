package refactor.Model.Entities.Show;

import java.util.Calendar;

public class SeasonShow extends Show{

    public SeasonShow(String title, String description, String category, Integer capacity, Calendar beginDate, Calendar endDate, int weekDay){

        super(title, description, category, capacity);
        
        if(beginDate.getTimeInMillis() != endDate.getTimeInMillis()){

            super.addSesion(beginDate, capacity);

            //TODO: add all weekdays between begin date and end date

            super.addSesion(endDate, capacity);
            
        } else { super.addSesion(beginDate, capacity); }

    }
    
}
