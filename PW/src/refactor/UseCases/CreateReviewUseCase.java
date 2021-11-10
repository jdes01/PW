package refactor.UseCases;

import java.io.IOException;

import refactor.Model.Entities.Review;
import refactor.Model.Entities.User;
import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.Score;
import refactor.Repository.UserRepository;

public class CreateReviewUseCase { 

    public static void createReview(User user, String title, String text, Show show, Score score) throws IOException{

      ReviewRepository reviewRepository = new ReviewRepository();
     
      Review review = new Review(user, title, text, show, score);
      
      reviewRepository.saveReview(review);
    
    }
    
}
