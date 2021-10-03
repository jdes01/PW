package Model;

import java.util.ArrayList;

import Model.DTO.Score;
import Model.DTO.ViewerReview;

import Model.Espectaculo;

public class Review {

    private Viewer viewer;

    private String title;

    private Score score;

    private String review_text;

    private ArrayList<ViewerReview> viewerReviews = new ArrayList<ViewerReview>();


    public Review(Viewer viewer, String title, Score score, String review_text){

        this.viewer = viewer;
        this.title = title;
        this.score = new Score(score.getScore());
        this.review_text = review_text;
    }

    public Integer getScore() {
        return this.score.getScore();
    }
    
    public void addViewerReview(Viewer viewer, Score score) {
    	
    	ViewerReview viewerReview = new ViewerReview(viewer, score);
    	
    	this.viewerReviews.add(viewerReview);
    }

}

