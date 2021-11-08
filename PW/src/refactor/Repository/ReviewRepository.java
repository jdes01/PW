package refactor.Repository;

import refactor.Model.Entities.Review;
import refactor.Model.Entities.User;
import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.Score;
import refactor.Repository.DAOs.ReviewDAO;

/**
 * Clase repositorio de las reviews
 * 
 * @author Marcos Rodriguez Moreno
 */

public class ReviewRepository {

/**
 * Funcion publica que guarda las reviews
 * 
 * @param review La review que se va a guardar
 */

    public void saveReview(User user, String title, String text, Show show, Score score){

        Review review = new Review(user, title, text, show, score);
        ReviewDAO reviewDAO = new ReviewDAO();

        reviewDAO.createReview(review);
    }
    
}
