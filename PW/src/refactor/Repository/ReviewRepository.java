package refactor.Repository;

import refactor.Model.Entities.Review;
import refactor.Model.Entities.User;
import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.Score;
import refactor.Repository.DAOs.ReviewDAO;

public class ReviewRepository {

    public void saveReview(User user, String title, String text, Show show, Score score){

        Review review = new Review(user, title, text, show, score);
        ReviewDAO reviewDAO = new ReviewDAO();

        reviewDAO.createReview(review);
    }
    
}
