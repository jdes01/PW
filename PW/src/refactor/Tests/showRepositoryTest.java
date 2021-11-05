package refactor.Tests;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import refactor.Model.Entities.Show.Show;
import refactor.Model.Entities.Show.ShowFactory;
import refactor.Repository.ShowRepository;

public class showRepositoryTest {

    @Test
    void saveShowTest() throws IOException{

        Calendar date1 = Calendar.getInstance();
        date1.set(2001, 6, 8);
        Calendar date2 = Calendar.getInstance();
        date2.set(2002, 7, 9);
        Calendar date3 = Calendar.getInstance();
        date3.set(2003, 8, 10);
        List<Calendar> dates = new ArrayList<Calendar>();
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        Show multiplePassShow = ShowFactory.createShow("title", "description", "category", 50, dates);



        Calendar date4 = Calendar.getInstance();
        date4.set(2001, 6, 8);
        Show punctualShow = ShowFactory.createShow("title", "description", "category", 50, date4);

        

        Calendar beginDate = Calendar.getInstance();
        beginDate.set(2021, 11, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2021, 12, 13);
        Show seasonShow = ShowFactory.createShow("title", "description", "category", 50, beginDate, endDate, 1);


        
        ShowRepository showRepository = new ShowRepository();

        showRepository.saveShow(multiplePassShow);
        showRepository.saveShow(punctualShow);
        showRepository.saveShow(seasonShow);
    }
}
