package refactor.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import refactor.model.Entities.Review;
import refactor.model.Entities.User;
import refactor.model.Entities.Show.Show;
import refactor.model.Entities.Show.ShowFactory;
import refactor.model.ValueObjects.Score;


public class reviewTest {

    @Test
    void reviewConstructorTest(){

        User user = new User("name", "lastName", "nickName", "mail");
        Calendar date = Calendar.getInstance();
        Show show = ShowFactory.createShow("title", "description", "category", 50, date);
        Score score = new Score(10);

        Review review = new Review(user, "title", "text", show, score);

        assertEquals(review.getScore().getScore(), 10);
    }

    @Test
    void addUserRatingTest(){

        User user = new User("name", "lastName", "nickName", "mail");
        Calendar date = Calendar.getInstance();
        Show show = ShowFactory.createShow("title", "description", "category", 50, date);
        Score score = new Score(10);

        Review review = new Review(user, "title", "text", show, score);

        User user2 = new User("name", "lastName", "nickName", "mail");
        Score score2 = new Score(5);
        review.addUserRating(user2, score2);

        assertEquals(review.getUserRatings().get(0).getScore().getScore(), 5);
    }
}
