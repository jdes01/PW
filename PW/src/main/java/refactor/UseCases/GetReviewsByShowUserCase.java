package refactor.UseCases;

import java.util.ArrayList;

import refactor.Model.Entities.Review;
import refactor.Repository.ReviewRepository;

public class GetReviewsByShowUserCase {
    
    public static ArrayList<Review> GetReviewsByShow(String id){

        ReviewRepository reviewRepository = new ReviewRepository();

        return reviewRepository.getReviewsByShow(id);
    }
}