package Handlers;

import java.util.ArrayList;

import Model.DTO.Score;
import Model.Entities.Review.Review;
import Model.Entities.User.User;

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
