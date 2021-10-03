package Model;

import java.util.ArrayList;

import Model.DTO.Score;
//import Model.DTO.ViewerReview;

import Model.Espectaculo;

public class Review {

    private Viewer viewer;

    private String title;

    private Score score;

    private String review_text;

    //private ArrayList<ViewerReview> viewerReview;


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

