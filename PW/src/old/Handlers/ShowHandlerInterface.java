package old.Handlers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import old.Model.Entities.User;
import old.Model.Entities.Review.Review;
import old.Model.Entities.Show.Show;

/**
 * Interfaz publica del handler del show
 * @author Javier De Santiago Palomino
 *
 */

public interface ShowHandlerInterface {
    
    Show createShow();

    ArrayList<Show> getShows();

    void cancelShow() throws IOException;

    void cancelAllShows();

    void updateShow() throws ParseException, IOException;

    void showTicketsForShowSesion(Show show, int sesion); //using dates array (in case of multiple-dates or periodic-date shows), print date, location and tickets
    
    Show getShowByTitle(String title);

    //Búsqueda de próximos espectáculos con entradas disponibles, indicando o no una categoría específica 

    void reviewAShow(Show show, User user);

    ArrayList<Review> getShowReviewsByName(String name);

    void deleteReview(User user, Show show);

    void rateShowReview(Review review);
}