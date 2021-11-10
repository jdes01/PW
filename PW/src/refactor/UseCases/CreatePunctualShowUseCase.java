package refactor.UseCases;

import java.util.Calendar;

import refactor.Repository.ShowRepository;

public class CreatePunctualShowUseCase {
    
    public static void createPunctualShow(String title, String description, String category, Integer capacity, Calendar date){

        ShowRepository showRepository = new ShowRepository();

        showRepository.saveShow(title, description, category, capacity, date);
    }
}
