package refactor.UseCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import refactor.Model.Entities.Review;

public class GetUserReviewsUseCase {

    public static List < Review > getUserReviews(String userMail) throws IOException{

        ReviewRepository reviewRepository = new ReviewRepository();

        ArrayList < Review > reviewList = new ArrayList <Review> ();
        
        reviewList=ReviewRepository.getAllReviewsByUser(userMail);

        return reviewList;
      
      }
    
}
