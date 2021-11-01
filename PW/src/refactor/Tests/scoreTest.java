package refactor.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import refactor.Model.ValueObjects.Score;



public class scoreTest {
    
    @Test
    void scoreGettersAndSetters(){

        Score score = new Score(2);
        assertEquals(2, score.getScore());

        score.setScore(5);
        assertEquals(5, score.getScore());
        assertNotEquals(score.getScore(), 2);

    }

    @Test
    void scoreAsserts(){

        try { 
            Score wrongScore = new Score(11);

          } catch ( Exception e ) {
            assertEquals(e.getMessage(), "wrong number");
          }

          try { 
            Score wrongScore = new Score(-1);
          } catch ( Exception e ) {
            assertEquals(e.getMessage(), "wrong number");
          }
        
    }
}
