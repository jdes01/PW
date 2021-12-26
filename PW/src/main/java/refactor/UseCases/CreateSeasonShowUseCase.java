package refactor.UseCases;

import java.util.Calendar;

import refactor.Repository.ShowRepository;

public class CreateSeasonShowUseCase {
    
    public static void createSeasonShow(String title, String description, String category, Integer capacity, Calendar beginDate, Calendar endDate, Integer weekDay){

        ShowRepository showRepository = new ShowRepository();

        showRepository.saveShow(title, description, category, capacity, beginDate, endDate, weekDay);
    }
}