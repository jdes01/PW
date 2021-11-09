package refactor.Model.ValueObjects;

import refactor.Model.Entities.User;

/**
 * Clase score del user
 * 
 * @author Javier De Santiago Palomino
 */

public class UserScore {
    
    private User  _user;
    private Score _score;

	/**
     * Cnstructor de UserScore
     * 
     * @param user Usuario
     * @param score Score
     */

    public UserScore(User user, Score score){

        this._user = user;
        this._score = score;
    }

/**
 * Getter del score
 * 
 * @return Score
 */

    public Score getScore(){ return this._score; }

/**
 * Getter del user
 * 
 * @return User
 */

    public User getUser(){   return this._user;  }

/**
 * Setter del score
 * 
 * @param score Score
 */

    public void setScore(Score score){ this._score = score; }

/**
 * Setter del user
 * 
 * @param user Usuario
 */

    public void setUser(User user){    this._user  = user;  }
}
