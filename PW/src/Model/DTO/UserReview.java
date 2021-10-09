package Model.DTO;

import Model.Entities.User.User;
public class UserReview {
    
    private User user;
    private Score score;

    public UserReview(User user, Score score){

        this.user = user;
        this.score = score;
    }

    public User getUser(){

        return this.user;
    }

    public void setUser(User User){

        this.user = User;
    }

    public Integer getScore(){

        return this.score.getScore();
    }

    public void setScore(Integer score){

        this.score.setScore(score);
    }
}
