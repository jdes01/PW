package Handlers;

import java.util.ArrayList;

import Model.Entities.Review.Review;
import Model.Entities.Show.Show;
import Model.Entities.User;

/**
 * Interfaz publica del handler del show
 * @author Javier De Santiago Palomino
 *
 */

public interface ShowHandlerInterface {
    
    Show createShow();

    ArrayList<Show> getShows();

    void cancelShow(Show show);

    void cancelAllShows();

    void updateShow();

    void showTicketsForShowSesion(Show show, int sesion); //using dates array (in case of multiple-dates or periodic-date shows), print date, location and tickets
    
    Show getShowByTitle(String title);

    //Búsqueda de próximos espectáculos con entradas disponibles, indicando o no una categoría específica 

    void reviewAShow(Show show, User user);

    ArrayList<Review> getShowReviewsByName(String name);

    void deleteReview(User user, Show show);

    void rateShowReview(Review review);
}