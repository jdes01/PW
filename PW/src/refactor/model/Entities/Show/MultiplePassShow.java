package refactor.model.Entities.Show;

import java.util.Calendar;
import java.util.List;

public class MultiplePassShow extends Show{

    public MultiplePassShow(String title, String description, String category, Integer capacity, List<Calendar> dates){

        super(title, description, category, capacity);

        for(Calendar date: dates){
            super.addSesion(date, capacity);
        }
    }
    
}
