package refactor.UseCases;

import java.util.ArrayList;
import java.util.Calendar;

import refactor.Repository.ShowRepository;

public class CreateMultiplePassShowUseCase {
    
    public static void createMultiplePassShow(String title, String description, String category, Integer capacity, ArrayList<Calendar> dates){

        ShowRepository showRepository = new ShowRepository();

        showRepository.saveShow(title, description, category, capacity, dates);
    }
}
