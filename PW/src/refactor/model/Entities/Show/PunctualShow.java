package refactor.model.Entities.Show;

import java.util.Calendar;

public class PunctualShow extends Show{

    public PunctualShow(String title, String description, String category, Integer capacity, Calendar date){

        super(title, description, category, capacity);

        super.addSesion(date, capacity);
    }
    
}
