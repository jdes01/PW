package refactor.UseCases;

import java.io.IOException;

import refactor.Model.ValueObjects.Score;
import refactor.Repository.UserRepository;

public class RateReviewUseCase {


    public static void rateReview(String title, String userMail, Score score) throws IOException{

        ReviewRepository reviewRepository = new ReviewRepository();

        reviewRepository.getReviewByTitle(title).addUserRating(UserRepository.getUserByMail(userMail), score);
      
      }
    
}
