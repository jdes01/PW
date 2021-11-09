package refactor.Tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import refactor.Model.Entities.Review;
import refactor.Model.Entities.User;
import refactor.Model.Entities.Show.Show;
import refactor.Model.Entities.Show.ShowFactory;
import refactor.Model.ValueObjects.Score;
import refactor.Repository.DAOs.ReviewDAO;

public class reviewDAOTest {
    
    @Test
    void createReviewTest(){

        User user = new User("name", "lastName", "nickName", "mail");
        Calendar date1 = Calendar.getInstance();
        date1.set(2001, 6, 8);
        Calendar date2 = Calendar.getInstance();
        date2.set(2002, 7, 9);
        Calendar date3 = Calendar.getInstance();
        date3.set(2003, 8, 10);
        List<Calendar> dates = new ArrayList<Calendar>();
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        Show show = ShowFactory.createShow("title", "description", "category", 50, dates);
        Score score = new Score(8);

        Review review = new Review(user, "title", "text", show, score);

        User user2 = new User("name", "lastName", "nickName", "mail");
        Score score2 = new Score(4);
        User user3 = new User("name", "lastName", "nickName", "mail");
        Score score3 = new Score(6);

        review.addUserRating(user2, score2);
        review.addUserRating(user3, score3);

        ReviewDAO reviewDAO = new ReviewDAO();
        reviewDAO.createReview(review);
    }
}
