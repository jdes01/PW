package Model.Entities.Review;
import java.util.ArrayList;

import Model.DTO.Score;
import Model.DTO.UserReview;

import Model.Entities.User.User;

public class Review {

    private User user;

    private String title;

    private Score score;

    private String reviewText;

    private ArrayList<UserReview> usersReviews = new ArrayList<UserReview>();


    public Review(User User, String title, Score score, String reviewText){

        this.user = User;
        this.title = title;
        this.score = new Score(score.getScore());
        this.reviewText = reviewText;
    }

    public Score getScore() {
        return this.score;
    }

    public String getTitle() {
        return this.title;
    }

    public String getReviewText() {
        return this.reviewText;
    }

    public ArrayList<UserReview> getUsersReviews(){

        return this.usersReviews;
    }
    
    public void addUserReview(User user, Score score) {
    	
    	UserReview userReview = new UserReview(user, score);
    	
    	this.usersReviews.add(userReview);
    }

}

