package refactor.Model.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.Score;
import refactor.Model.ValueObjects.UserScore;

public class Review {
    
    private UUID   _id;
    private User   _user;
    private String _title;
    private String _text;
    private Show   _show;
    private Score  _score;

    private List<UserScore> _userRatings = new ArrayList<UserScore>();


    public Review(User user, String title, String text, Show show, Score score){

        UUID uuid = UUID.randomUUID();
        this._id = uuid;

        this._user  = user;
        this._title = title;
        this._text = text;
        this._show  = show;
        this._score = score;
    }

    public UUID getId(){ return _id; }
    public User getUser(){ return _user; }
    public String getTitle(){ return _title; }
    public String getText(){ return _text; }
    public Show getShow(){ return _show; }
    public Score getScore(){ return _score; }
    public List<UserScore> getUserRatings(){ return _userRatings; }


    public void setUser(User user){ this._user = user; }
    public void setTitle(String title){ this._title = title; }
    public void setText(String text){ this._text = text; }
    public void setShow(Show show){ this._show = show; }
    public void setScore(Score score){ this._score = score; }

    public void addUserRating(User user, Score score){
        assert this._user.getUuid() != user.getUuid();

        for(UserScore i: this._userRatings){
            if(i.getUser().getUuid() == user.getUuid()){ return; }
        }

        UserScore userScore = new UserScore(user, score);
        this._userRatings.add(userScore);
    }

}
