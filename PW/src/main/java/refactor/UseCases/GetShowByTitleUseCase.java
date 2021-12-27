package refactor.UseCases;

import java.io.IOException;

import refactor.Model.Entities.Show.Show;
import refactor.Repository.ShowRepository;

public class GetShowByTitleUseCase {

    public static Show getShowByTitle(String title) throws IOException{

         ShowRepository showRepository = new ShowRepository();
         
         return showRepository.getShowByTitle(title);
    }
}