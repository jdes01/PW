package refactor.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import refactor.Model.Entities.Show.Show;
import refactor.Model.Entities.Show.ShowFactory;
import refactor.Model.ValueObjects.ShowSesion;
import refactor.Repository.DAOs.ShowDAO;

/**
 * Clase repositorio de los shows
 * 
 * @author Alberto Cano Turnes
 */

public class ShowRepository {

    private String path = System.getProperty("user.dir") + File.separator + "src/refactor/Repository/shows.txt";
    
    public ShowRepository(){}

    
    /** 
     * Funcion que guarda los shows en un fichero de texto
     * 
     * @param show Show
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
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

    
    /** 
     * Funcion para guardar shows
     * 
     * @param title Titulo del show
     * @param description Descripcion del show
     * @param category Categoria del show
     * @param capacity Capacidad del show
     * @param dates Fechas del show
     */
    //MultiplePass Show instance
    public void saveShow(String title, String description, String category, Integer capacity, List<Calendar> dates){

        Show show = ShowFactory.createShow(title, description, category, capacity, dates);
        ShowDAO showDAO = new ShowDAO();

        showDAO.createShow(show);
        showDAO.createShowSesions(show);
    }

    
    /** 
     * Funcion para guardar shows
     * 
     * @param title Titulo del show
     * @param description Descripcion del show
     * @param category Categoria del show
     * @param capacity Capacidad del show
     * @param dates Fechas del show
     */

    public void saveShow(String title, String description, String category, Integer capacity, Calendar date){

        Show show = ShowFactory.createShow(title, description, category, capacity, date);
        ShowDAO showDAO = new ShowDAO();

        showDAO.createShow(show);
        showDAO.createShowSesions(show);
    }

    
    /** 
     * Funcion para guardar el show
     * 
     * @param title Titulo del show
     * @param description Descripcion del show
     * @param category Categoria del show
     * @param capacity Capacidad del show
     * @param beginDate Fecha de inicio del show
     * @param endDate Fecha de finalizacion del show
     * @param weekDay Dia de la semana del show
     */
    public void saveShow(String title, String description, String category, Integer capacity, Calendar beginDate, Calendar endDate, int weekDay){

        Show show = ShowFactory.createShow(title, description, category, capacity, beginDate, endDate, weekDay);
        ShowDAO showDAO = new ShowDAO();

        showDAO.createShow(show);
        showDAO.createShowSesions(show);
    }

    
    
    /** 
     * Getter del show a partir del titulo
     * 
     * @param title Titulo del show
     * @return Show
     */

    public Show getShowByTitle(String title){

        ShowDAO showDAO = new ShowDAO();

        return showDAO.getShowByTitle(title);
    }

    
    /** 
     * Getter de todos los shows
     * 
     * @return ArrayList<Show>
     */

    public ArrayList<Show> getAllShows(){

        ShowDAO showDAO = new ShowDAO();
        return showDAO.getAllShows();
    }
    
    public void deleteShowSesion(int Id) {
    	ShowDAO showDAO = new ShowDAO();
    	showDAO.deleteShowSesion(Id);
    }
    
    public void updateShowSesion(int id, Calendar date, int capacity) {
    	ShowDAO showDAO = new ShowDAO();
    	showDAO.updateShowSesion(id, date, capacity);
    }
    
}
