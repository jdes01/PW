package Model.DTO;

import Model.Viewer;

public class ViewerReview {
    
    private Viewer viewer;
    private Score score;

    public ViewerReview(Viewer viewer, Score score){

        this.viewer = viewer;
        this.score = score;
    }

    public Viewer getViewer(){

        return this.viewer;
    }

    public void setUser(Viewer viewer){

        this.viewer = viewer;
    }

    public Integer getScore(){

        return this.score.getScore();
    }

    public void setScore(Integer score){

        this.score.setScore(score);
    }
}
