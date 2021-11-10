package refactor.UseCases;

import java.io.IOException;

import refactor.Model.ValueObjects.Score;
import refactor.Repository.ReviewRepository;
import refactor.Repository.ShowRepository;
import refactor.Repository.UserRepository;

public class CreateReviewUseCase { 

    public static void createReview(String userMail, String title, String text, String showTitle, Score score) throws IOException{

      ReviewRepository reviewRepository = new ReviewRepository();

      ShowRepository showRepository = new ShowRepository();
      
      UserRepository userRepository = new UserRepository();
           
      reviewRepository.saveReview(userRepository.getUserByMail(userMail), title, text, showRepository.getShowByTitle(showTitle), score);
    
    }
    
}
