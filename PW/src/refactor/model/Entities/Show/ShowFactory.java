package refactor.model.Entities.Show;

import java.util.Calendar;
import java.util.List;

public class ShowFactory {


    public static Show createShow(String title, String description, String category, Integer capacity, Calendar date){
        PunctualShow punctualShow = new PunctualShow(title, description, category, capacity, date);
        return punctualShow;
    }


    public static Show createShow(String title, String description, String category, Integer capacity, Calendar beginDate, Calendar endDate, int weekDay){
        SeasonShow seasonShow = new SeasonShow(title, description, category, capacity, beginDate, endDate, weekDay);
        return seasonShow;
    }


    public static Show createShow(String title, String description, String category, Integer capacity, List<Calendar> dates){
        MultiplePassShow multiplePassShow = new MultiplePassShow(title, description, category, capacity, dates);
        return multiplePassShow;
    }
    
}
