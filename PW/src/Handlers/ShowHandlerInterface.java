public interface ShowHandlerInterface {
    
    void createShow();

    ArrayList<Show> getShows();

    void cancelShow(Show show);

    void cancelAllShows();

    void updateShow();

    void showTicketsForShowSesion(Show show, Int sesion); //using dates array (in case of multiple-dates or periodic-date shows), print date, location and tickets
    
    void getShowByTitle(String title);

    //Búsqueda de próximos espectáculos con entradas disponibles, indicando o no una categoría específica 

    void reviewAShow(Show show);

    ArrayList<Review> getShowReviewsByName(String name);

    void deleteReview(User user, Show show);

    void rateShowReview(Review review);
}