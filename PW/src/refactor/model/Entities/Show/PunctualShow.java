package refactor.model.Entities.Show;

import java.util.Calendar;

public class PunctualShow extends Show{

    public PunctualShow(String title, String description, String category, Calendar date){

        super("a", "b", "c");
        super.getSesions().add(date);
    }
    
}
