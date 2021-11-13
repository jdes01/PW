package refactor.UseCases;

import refactor.Model.Entities.Review;
import refactor.Repository.ReviewRepository;

public class GetReviewByTitleUseCase {
    
    public static Review getReviewByTitle(String title){

        ReviewRepository reviewRepository = new ReviewRepository();

        for(Review review: reviewRepository.getAllReviews()){

            if(review.getTitle() == title){ return review; }
        }
        return null;
    }
}
