package Model.DTO;

import Model.Entities.User;

/**
 * Clase usuario de la review
 * @author Alberto Cano Turnes
 *
 */

public class UserReview {
    
    private User user;
    private Score score;

/**
 * Constructor de UserReview
 * @param user Usuario de la review 
 * @param score Score de la review
 */
    
    public UserReview(User user, Score score){

        this.user = user;
        this.score = score;
    }
    
/**
 * Getter de usuarios
 * @return Retorna el usuario
 */

    public User getUser(){

        return this.user;
    }
    
/**
 * Setter de usuarios
 * @param User Usuario de la review
 */

    public void setUser(User User){

        this.user = User;
    }

/**
 * Getter del score de la review
 * @return Retorna el score de la review
 */
    
    public Integer getScore(){

        return this.score.getScore();
    }

/**
 * Setter de la review
 * @param score Score de la review
 */
    
    public void setScore(Integer score){

        this.score.setScore(score);
    }
}
