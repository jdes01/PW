package refactor.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import refactor.Model.Entities.Show.Show;
import refactor.Model.Entities.Show.ShowFactory;
import refactor.Model.ValueObjects.ShowSesion;
import refactor.Repository.DAOs.ShowDAO;

public class ShowRepository {

    private String path = System.getProperty("user.dir") + File.separator + "src/refactor/Repository/shows.txt";
    
    public ShowRepository(){}

    public void saveShowInTextFile(Show show) throws IOException {

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(path), ("Show").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), show.getUuid().toString().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), show.getTitle().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), show.getDescription().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), show.getCategory().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), String.valueOf(show.getCapacity()).getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(path), (" Sesions:").getBytes(), StandardOpenOption.APPEND);

        for(ShowSesion showSesion: show.getSesions()){

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format1.format(showSesion.getDate().getTime());
            
            Files.write(Paths.get(path), (" [").getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(path), formatted.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(path), String.valueOf(showSesion.getTickets()).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(path), (" ]").getBytes(), StandardOpenOption.APPEND);
        }

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);
    }

    //MultiplePass Show instance
    public void saveShow(String title, String description, String category, Integer capacity, List<Calendar> dates){

        Show show = ShowFactory.createShow(title, description, category, capacity, dates);
        ShowDAO showDAO = new ShowDAO();

        showDAO.createShow(show);
        showDAO.createShowSesions(show);
    }

    public void saveShow(String title, String description, String category, Integer capacity, Calendar date){

        Show show = ShowFactory.createShow(title, description, category, capacity, date);
        ShowDAO showDAO = new ShowDAO();

        showDAO.createShow(show);
        showDAO.createShowSesions(show);
    }

    public void saveShow(String title, String description, String category, Integer capacity, Calendar beginDate, Calendar endDate, int weekDay){

        Show show = ShowFactory.createShow(title, description, category, capacity, beginDate, endDate, weekDay);
        ShowDAO showDAO = new ShowDAO();

        showDAO.createShow(show);
        showDAO.createShowSesions(show);
    }

    public Show getShowByTitle(String title){

        ShowDAO showDAO = new ShowDAO();

        return showDAO.getShowByTitle(title);
    }
}
