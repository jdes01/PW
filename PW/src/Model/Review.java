package Model;

import java.util.ArrayList;

import Model.DTO.Score;

import Model.DTO.UserReview;

import Model.Espectaculo;

public class Review {

    private Viewer viewer;

    private String title;

    private Score score;

    private String review_text;

    private ArrayList<UserReview> user_reviews;


    public Review(Viewer viewer, String title, Score score, String review_text){

        this.viewer = viewer;
        this.title = title;
        this.score = new Score(score.getScore());
        this.review_text = review_text;
    }

    public Integer getScore() {
        return this.score.getScore();
    }

}

