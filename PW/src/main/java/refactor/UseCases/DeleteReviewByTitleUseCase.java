package refactor.UseCases;

import refactor.Repository.ReviewRepository;

public class DeleteReviewByTitleUseCase {
    
    public static void deleteReviewByTitle(String title){

        ReviewRepository reviewRepository = new ReviewRepository();

        reviewRepository.deleteReviewByTitle(title);
    }
}