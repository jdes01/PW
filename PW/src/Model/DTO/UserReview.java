package Model.DTO;

public class UserReview {
    
    private User user;
    private Score score;

    public UserReview(User user, Score score){

        this.user = user;
        this.score = score;
    }

    public Integer getUser(){

        return this.user.getUser();
    }

    public void setUser(User user){

        this.user = user;
    }

    public Integer getScore(){

        return this.score.getScore();
    }

    public void setScore(Integer score){

        this.score.setScore(score);
    }
}
