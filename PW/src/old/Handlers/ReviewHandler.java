package old.Handlers;

import java.util.ArrayList;

import old.Model.DTO.Score;
import old.Model.Entities.User;
import old.Model.Entities.Review.Review;

/**
 * Interfaz publica del handler de review
 * @author Javier De Santiago Palomino
 *
 */

public interface ReviewHandler {

    void createReview(User user);

    ArrayList<Review> getReviews();

    void deleteReview(Review review);

    void voteReview(Review review, User user, Score score);
}
