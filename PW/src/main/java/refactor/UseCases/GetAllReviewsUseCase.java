package refactor.UseCases;

import java.io.IOException;
import java.util.ArrayList;

import refactor.Model.Entities.Review;
import refactor.Repository.ReviewRepository;

public class GetAllReviewsUseCase {

    public static ArrayList<Review> getAllReviews() throws IOException{

         ReviewRepository reviewRepository = new ReviewRepository();
        
         return reviewRepository.getAllReviews();
        }
    
}