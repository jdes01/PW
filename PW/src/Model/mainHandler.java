public class mainHandler extends HandleReviewsInterface, HandleViewerInterface {
    
    // handle viewer

    void createViewer(){}

    void deleteViewer(Viewer viewer){}

    Viewer getViewer(Integer id){}

    void updateViewer(Viewer viewer){}

    // handle review

    void createReview(Viewer viewer){}

    ArrayList<Review> getReviews(){}

    void deleteReview(Review review){}

    void voteReview(Review review, Viewer viewer, Score score){}
}
