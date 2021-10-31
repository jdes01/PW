package refactor.model.ValueObjects;

import refactor.model.Entities.User;

public class UserReview {
    
    private User  _user;
    private Score _score;

    public UserReview(User user, Score score){

        this._user = user;
        this._score = score;
    }

    public Score getScore(){ return this._score; }
    public User getUser(){   return this._user;  }

    public void setScore(Score score){ this._score = score; }
    public void setUser(User user){    this._user  = user;  }
}
