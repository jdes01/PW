package refactor.Tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import refactor.Model.Entities.Show.Show;
import refactor.Model.Entities.Show.ShowFactory;
import refactor.Repository.DAOs.ShowDAO;

public class showDAOTest {


    @Test
    void showDAOCreateShowTest() throws IOException {

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

        String titleString = UUID.randomUUID().toString();
        String descriptionString = UUID.randomUUID().toString();
        String categoryString = UUID.randomUUID().toString();

        Show show = ShowFactory.createShow(titleString, descriptionString, categoryString, 50, dates);

        ShowDAO showDAO = new ShowDAO();
        showDAO.createShow(show);
    }

    @Test
    void showDAOCreateShowSesionsMultiplePassShowTest() throws IOException {

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

        String titleString = UUID.randomUUID().toString();
        String descriptionString = UUID.randomUUID().toString();
        String categoryString = UUID.randomUUID().toString();

        Show show = ShowFactory.createShow(titleString, descriptionString, categoryString, 50, dates);

        assertEquals(show.getSesions().isEmpty(), false);
        ShowDAO showDAO = new ShowDAO();
        showDAO.createShowSesions(show);
    }


    @Test
    void showDAOCreateShowSesionsSeasonPassShowTest() throws IOException {

        Calendar beginDate = Calendar.getInstance();
        beginDate.set(2021, 10, 1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2021, 11, 13);

        String titleString = UUID.randomUUID().toString();
        String descriptionString = UUID.randomUUID().toString();
        String categoryString = UUID.randomUUID().toString();

        Show show = ShowFactory.createShow(titleString, descriptionString, categoryString, 50, beginDate, endDate, 1);

        assertEquals(show.getSesions().isEmpty(), false);
        ShowDAO showDAO = new ShowDAO();
        showDAO.createShowSesions(show);
    }


    @Test
    void showDAOCreateShowSesionsPunctualShowTest() throws IOException {

        Calendar date = Calendar.getInstance();
        date.set(2021, 11, 1);

        String titleString = UUID.randomUUID().toString();
        String descriptionString = UUID.randomUUID().toString();
        String categoryString = UUID.randomUUID().toString();

        Show show = ShowFactory.createShow(titleString, descriptionString, categoryString, 50, date);

        assertEquals(show.getSesions().isEmpty(), false);
        ShowDAO showDAO = new ShowDAO();
        showDAO.createShowSesions(show);
    }

    
}
