package refactor.tests;

import refactor.model.Entities.Show;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class showTest {

    @Test
    void constructorAndGettersTest(){

        Show show = new Show("title", "description", "category", 1);

        assertEquals(show.getTitle(), "title");
        assertEquals(show.getDescription(), "description");
        assertEquals(show.getCategory(), "category");
        assertEquals(show.getScore(), 1);

        Show show2 = new Show("title2", "description2", "category2", 2);
        assertNotEquals(show.getUuid(), show2.getUuid());
    }

    @Test
    void settersTest(){

        Show show = new Show("title", "description", "category", 1);
        assertEquals(show.getTitle(), "title");
        assertEquals(show.getDescription(), "description");
        assertEquals(show.getCategory(), "category");
        assertEquals(show.getScore(), 1);

        show.setTitle("newtitle");
        show.setDescription("newdescription");
        show.setCategory("newcategory");
        show.setScore(2);

        assertEquals(show.getTitle(), "newtitle");
        assertEquals(show.getDescription(), "newdescription");
        assertEquals(show.getCategory(), "newcategory");
        assertEquals(show.getScore(), 2);
    }
    
}
