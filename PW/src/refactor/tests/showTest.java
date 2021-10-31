package refactor.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.Year;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.CalendarConversion;

import refactor.model.Entities.Show.PunctualShow;
import refactor.model.Entities.Show.Show;

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
        /*
        Calendar date = Calendar.getInstance();
        date.set(2001, 6, 8);

        assertEquals(date.get(Calendar.YEAR), 2001);
        assertEquals(date.get(Calendar.MONTH), 6);
        assertEquals(date.get(Calendar.DAY_OF_MONTH), 8);

        PunctualShow punctualShow = new PunctualShow("title", "description", "category", date);

        assertEquals(punctualShow.getSesions().get(0).get(Calendar.YEAR), 2001);
        */
    }
}
