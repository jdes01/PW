package refactor.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import refactor.Model.Entities.Show.MultiplePassShow;
import refactor.Model.Entities.Show.PunctualShow;
import refactor.Model.Entities.Show.SeasonShow;
import refactor.Model.Entities.Show.Show;
import refactor.Model.Entities.Show.ShowFactory;

public class showTest {

    @Test
    void constructorAndGettersTest(){

        Show show = new Show("title", "description", "category", 50);

        assertEquals(show.getTitle(), "title");
        assertEquals(show.getDescription(), "description");
        assertEquals(show.getCategory(), "category");
        assertEquals(show.getCapacity(), 50);

        Show show2 = new Show("title2", "description2", "category20", 50);
        assertNotEquals(show.getUuid(), show2.getUuid());
    }


    @Test
    void settersTest(){

        Show show = new Show("title", "description", "category", 50);
        assertEquals(show.getTitle(), "title");
        assertEquals(show.getDescription(), "description");
        assertEquals(show.getCategory(), "category");
        assertEquals(show.getCapacity(), 50);

        show.setTitle("newtitle");
        show.setDescription("newdescription");
        show.setCategory("newcategory");
        show.setCapacity(100);

        assertEquals(show.getTitle(), "newtitle");
        assertEquals(show.getDescription(), "newdescription");
        assertEquals(show.getCategory(), "newcategory");
        assertEquals(show.getCapacity(), 100);
    }


    @Test
    void showSesions(){

        Show show = new Show("title", "description", "category", 50);
        assertEquals(show.getSesions().isEmpty(), true);

        Calendar date = Calendar.getInstance();
        date.set(2001, 6, 8);
        show.addSesion(date, 50);

        assertEquals(show.getSesions().isEmpty(), false);
        assertEquals(show.getSesions().get(0).getDate().get(Calendar.YEAR), 2001);
        assertEquals(show.getSesions().get(0).getDate().get(Calendar.MONTH), 6);
        assertEquals(show.getSesions().get(0).getDate().get(Calendar.DAY_OF_MONTH), 8);
    }
    

    @Test
    void punctualShowTest(){

        Calendar date = Calendar.getInstance();
        date.set(2001, 6, 8);

        assertEquals(date.get(Calendar.YEAR), 2001);
        assertEquals(date.get(Calendar.MONTH), 6);
        assertEquals(date.get(Calendar.DAY_OF_MONTH), 8);

        PunctualShow punctualShow = new PunctualShow("title", "description", "category", 50, date);

        assertEquals(punctualShow.getSesions().isEmpty(), false);

        assertEquals(punctualShow.getSesions().get(0).getDate().get(Calendar.YEAR), 2001);
        assertEquals(punctualShow.getSesions().get(0).getDate().get(Calendar.MONTH), 6);
        assertEquals(punctualShow.getSesions().get(0).getDate().get(Calendar.DAY_OF_MONTH), 8);
    
    }



    @Test
    void MultiplePassShow(){

        Calendar date1 = Calendar.getInstance();
        date1.set(2001, 6, 8);

        assertEquals(date1.get(Calendar.YEAR), 2001);
        assertEquals(date1.get(Calendar.MONTH), 6);
        assertEquals(date1.get(Calendar.DAY_OF_MONTH), 8);

        Calendar date2 = Calendar.getInstance();
        date2.set(2002, 7, 9);

        Calendar date3 = Calendar.getInstance();
        date3.set(2003, 8, 10);

        List<Calendar> dates = new ArrayList<Calendar>();
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);


        MultiplePassShow multiplePassShow = new MultiplePassShow("title", "description", "category", 50, dates);

        assertEquals(multiplePassShow.getSesions().isEmpty(), false);

        assertEquals(multiplePassShow.getSesions().get(0).getDate().get(Calendar.MONTH), 6);
        assertEquals(multiplePassShow.getSesions().get(1).getDate().get(Calendar.YEAR), 2002);
        assertEquals(multiplePassShow.getSesions().get(2).getDate().get(Calendar.DAY_OF_MONTH), 10);
    
    }
    


    @Test
    void SeasonShow(){

        Calendar beginDate = Calendar.getInstance();
        beginDate.set(2021, 11, 1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2021, 12, 13);

        SeasonShow seasonShow = new SeasonShow("title", "description", "category", 50, beginDate, endDate, 1);

        assertEquals(seasonShow.getSesions().isEmpty(), false);

        assertEquals(seasonShow.getSesions().get(0).getDate().get(Calendar.DAY_OF_MONTH), 1);
        assertEquals(seasonShow.getSesions().get(1).getDate().get(Calendar.DAY_OF_MONTH), 13);

        //TODO: update tests when finishing season show todo
    }



    @Test
    void ShowFactory(){

        Calendar date = Calendar.getInstance();
        Show punctualShow = ShowFactory.createShow("title", "description", "category", 50, date);
        assertInstanceOf(PunctualShow.class, punctualShow);

        List<Calendar> dates = new ArrayList<Calendar>();
        Show multiplePassShow = ShowFactory.createShow("title", "description", "category", 50, dates);
        assertInstanceOf(MultiplePassShow.class, multiplePassShow);


        Show seasonShow = ShowFactory.createShow("title", "description", "category", 50, date, date, 1);
        assertInstanceOf(SeasonShow.class, seasonShow);
    }
}
