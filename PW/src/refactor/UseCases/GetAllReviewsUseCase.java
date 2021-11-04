package refactor.UseCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import refactor.Model.Entities.Review;

public class GetAllReviewsUseCase {

    public static List<Review> GetAllReviews() throws IOException{

         ReviewRepository reviewRepository = new ReviewRepository();

         ArrayList < Review > listaReviews = new ArrayList <Review> ();
        
         listaReviews=ReviewRepository.GetAllReviews();
        
        }
    
}
