package Model;

import java.util.ArrayList;

import Model.DTO.Score;
import Model.DTO.UserReview;

import Model.Espectaculo;

public class Review {

    private User user;

    private String title;

    private Score score;

    private String review_text;

    private ArrayList<UserReview> userReview = new ArrayList<UserReview>();


    public Review(User User, String title, Score score, String review_text){

        this.user = user;
        this.title = title;
        this.score = new Score(score.getScore());
        this.review_text = review_text;
    }

    public Integer getScore() {
        return this.score.getScore();
    }
    
    public void addUserReview(User user, Score score) {
    	
    	UserReview userReview = new UserReview(user, score);
    	
    	this.userReview.add(userReview);
    }

}

