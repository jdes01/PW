package refactor.Model.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.Score;
import refactor.Model.ValueObjects.UserScore;

/**
 * Clase review que tiene todo lo relacionado a las reviews
 * 
 * @author Alberto Cano Turnes
 */

public class Review {
    
    private UUID   _id;
    private String _title;
    private String _text;
    private User   _user;
    private Show   _show;
    private Score  _score;

    private List<UserScore> _userRatings = new ArrayList<UserScore>();

/**
 * Constructor de review
 * 
 * @param user El usuario que escribe la review
 * @param title Titulo de la review
 * @param text Texto de la review
 * @param show Show de la review
 * @param score Score de la review
 */

    public Review(User user, String title, String text, Show show, Score score){

        UUID uuid = UUID.randomUUID();
        this._id = uuid;

        this._user  = user;
        this._title = title;
        this._text = text;
        this._show  = show;
        this._score = score;
    }

    public Review() {}
    
    /** 
     * Getter de ID
     * 
     * @param user Usuario
     * @param score Score
     * @return UUID
     */

    public UUID getId(){ return _id; }
    
    /** 
     * Getter de user
     * 
     * @param user Usuario
     * @param score Score
     * @return User
     */
    public User getUser(){ return _user; }
    
    /** 
     * Getter del titulo
     * 
     * @param user Usuario
     * @param score Score
     * @return String
     */
    public String getTitle(){ return _title; }
    
    /** 
     * Getter del texto
     * 
     * @param user Usuario
     * @param score Score
     * @return String
     */
    public String getText(){ return _text; }
    
    /** 
     * Getter del show
     * 
     * @param user Usuario
     * @param score Score
     * @return Show
     */
    public Show getShow(){ return _show; }
    
    /** 
     * Getter del score
     * 
     * @param user Usuario
     * @param score Score
     * @return Score
     */
    public Score getScore(){ return _score; }
    
    /** 
     * Getter de los ratings
     * 
     * @param user Usuario
     * @param score Score
     * @return List<UserScore>
     */
    public List<UserScore> getUserRatings(){ return _userRatings; }


    
    /** 
     * Setter de usuarios
     * 
     * @param user Usuario
     * @param score Score
     */
    public void setUser(User user){ this._user = user; }
    
    /** 
     * Setter de titulos
     * 
     * @param user Usuario
     * @param score Score
     */
    public void setTitle(String title){ this._title = title; }
    
    /** 
     * Setter del texto
     * 
     * @param user Usuario
     * @param score Score
     */
    public void setText(String text){ this._text = text; }
    
    /** 
     * Setter del show
     * 
     * @param user Usuario
     * @param score Score
     */
    public void setShow(Show show){ this._show = show; }
    
    /** 
     * Setter del score
     * 
     * @param user Usuario
     * @param score Score
     */
    public void setScore(Score score){ this._score = score; }

    /** 
     * Setter de la ID
     * 
     * @param String Id
     */
    public void setId(String Id) {this._id = UUID.fromString(Id); }
    
    /** 
     * Funcion para añadir los ratings de los usuarios 
     * 
     * @param user Usuario
     * @param score Score
     */

    public void addUserRating(User user, Score score){
        assert this._user.getUuid() != user.getUuid();

        for(UserScore i: this._userRatings){
            if(i.getUser().getUuid() == user.getUuid()){ return; }
        }

        UserScore userScore = new UserScore(user, score);
        this._userRatings.add(userScore);
    }

}
