package refactor.UseCases;

import refactor.Model.Entities.Review;
import refactor.Model.Entities.User;
import refactor.Model.ValueObjects.Score;
import refactor.Repository.ReviewRepository;
import refactor.Repository.UserRepository;

public class RateReviewByUser {
 
    public static void rateReviewByUser(Review review, String userMail, Integer intScore){

        UserRepository userRepository = new UserRepository();
        
        Score score = new Score(intScore);
        User user = userRepository.getUserByMail(userMail);

        review.addUserRating(user, score);
        ReviewRepository reviewRepository = new ReviewRepository();
        
        reviewRepository.saveUserRating(review, user, score);
    }
}