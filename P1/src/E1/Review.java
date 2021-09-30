package E1;

import java.util.ArrayList;

import E1.DTO.User;

import E1.DTO.Score;
import E1.DTO.UserReview;

public class Review {

    private User user;

    private String title;

    private Score score;

    private String review_text;

    private ArrayList<UserReview> user_reviews;


    public Review(User user, String title, Integer score, String review_text){

        this.user = user;
        this.title = title;
        this.score = new Score(score);
        this.review_text = review_text;
    }

}

