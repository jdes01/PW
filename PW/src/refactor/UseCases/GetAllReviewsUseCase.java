package refactor.UseCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import refactor.Model.Entities.Review;

public class GetAllReviewsUseCase {

    public static List<Review> getAllReviews() throws IOException{

         ReviewRepository reviewRepository = new ReviewRepository();

         ArrayList < Review > reviewList = new ArrayList <Review> ();
        
         reviewList=ReviewRepository.getAllReviews();

         return reviewList;
        
        }
    
}
