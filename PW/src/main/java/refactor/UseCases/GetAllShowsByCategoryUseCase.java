package refactor.UseCases;

import java.util.ArrayList;

import refactor.Model.Entities.Show.Show;
import refactor.Repository.ShowRepository;

public class GetAllShowsByCategoryUseCase {
    
    public static ArrayList<Show> GetAllShowsByCategory(String category){

        ShowRepository showRepository = new ShowRepository();

        return showRepository.getAllShowsByCategory(category);
    }
}