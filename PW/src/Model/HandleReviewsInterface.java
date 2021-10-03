package Model;

import java.util.ArrayList;

import Model.Viewer;
import Model.DTO.Score;
import Model.Review;

public interface HandleReviewsInterface {

    void createReview(Viewer viewer);

    ArrayList<Review> getReviews();

    void deleteReview(Review review);

    void voteReview(Review review, Viewer viewer, Score score);
}
