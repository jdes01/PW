package refactor.UseCases;

import java.util.ArrayList;

import refactor.Model.Entities.Show.Show;
import refactor.Repository.ShowRepository;

public class GetAllShowsUseCase {
    
    public static ArrayList<Show> getAllShows(){

        ShowRepository showRepository = new ShowRepository();

        return showRepository.getAllShows();
    }
}