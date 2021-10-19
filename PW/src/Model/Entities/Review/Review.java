package Model.Entities.Review;
import java.util.ArrayList;

import Model.DTO.Score;
import Model.DTO.UserReview;

import Model.Entities.User;

/**
 * Clase review que tiene todo lo relacionado a las reviews
 * @author Alberto Cano Turnes
 *
 */

public class Review {

    private User user;

    private String title;

    private Score score;

    private String reviewText;

    private ArrayList<UserReview> usersReviews = new ArrayList<UserReview>();

/**
 * Constructor de review
 * @param User El usuario que escribe la review
 * @param title Titulo de la review
 * @param score Score de la review
 * @param reviewText Texto de la review
 */
    
    public Review(User User, String title, Score score, String reviewText){

        this.user = User;
        this.title = title;
        this.score = new Score(score.getScore());
        this.reviewText = reviewText;
    }
    
/**
 * Getter de score
 * @return Retorna el score
 */

    public Score getScore() {
        return this.score;
    }
    
/**
 * Getter de titulo
 * @return Retorna el titulo
 */

    public String getTitle() {
        return this.title;
    }
    
/**
 * Getter del texto de la review
 * @return Retorna el texto 
 */

    public String getReviewText() {
        return this.reviewText;
    }
    
/**
 * Getter del usuario de la review
 * @return Retorna el user 
 */

        public User getUser() {
            return this.user;
        }
        
    
/**
 * Getter de la review de los usuarios
 * @return Retorna la review de los usuarios
 */

    public ArrayList<UserReview> getUsersReviews(){

        return this.usersReviews;
    }
    
/**
 * Funcion publica que añade la review del usuario
 * @param user El usuario de la review
 * @param score El score de la review
 */
    
    public void addUserReview(User user, Score score) {
    	
    	UserReview userReview = new UserReview(user, score);
    	
    	this.usersReviews.add(userReview);
    }

}

