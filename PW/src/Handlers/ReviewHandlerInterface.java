public interface ReviewHandlerInterface {

    Review createReview(User user);

    ArrayList<Review> getReviews();

    void deleteReview(Review review);

    void voteReview(Review review, User user, Score score);
}