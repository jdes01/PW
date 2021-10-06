public interface ShowHandler {
    
    void createPunctualShow();

    void createMultiplePassShow();

    void createSeasonShow();

    ArrayList<Show> getShows();
}