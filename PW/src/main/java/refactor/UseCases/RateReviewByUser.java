package refactor.UseCases;

import refactor.Model.Entities.Review;
import refactor.Model.ValueObjects.Score;
import refactor.Repository.UserRepository;

public class RateReviewByUser {
 
    public static void rateReviewByUser(Review review, String userMail, Integer intScore){

        UserRepository userRepository = new UserRepository();
        
        Score score = new Score(intScore);

        review.addUserRating(userRepository.getUserByMail(userMail), score);
    }
}