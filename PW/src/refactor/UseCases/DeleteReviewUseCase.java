package refactor.UseCases;

import java.io.IOException;

public class DeleteReviewUseCase {


    public static void deleteReview(String title) throws IOException{

        ReviewRepository reviewRepository = new ReviewRepository();
        
        reviewRepository.deleteReviewByTitle(title);
      
      }
    
}
