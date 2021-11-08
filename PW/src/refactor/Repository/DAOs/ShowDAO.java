package refactor.Repository.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.ShowSesion;

/**
 * Clase encargada de escribir en la base de datos toda la información relacionada con los shows del sistema.
 * 
 * @author Marcos Rodríguez Moreno
 */
public class ShowDAO {
    
    /**
     * Constructor de la clase ShowDAO.
     */
    public ShowDAO(){}

    /** 
     * Función encargada de añadir a la base de datos un nuevo objeto Show.
     * 
     * @param show Objeto Show que se quiere añadir a la base de datos.
     */
    public void createShow(Show show){

        try{
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `Show` values(?,?,?,?,?)");

                ps.setString(1, show.getUuid().toString());
                ps.setString(2, show.getTitle());
                ps.setString(3, show.getDescription());
                ps.setString(4, show.getCategory());
                ps.setInt(5, show.getCapacity());

                ps.executeUpdate();

                if (ps != null){ 
                    ps.close(); 
                }
                connection.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    /** 
     * Descripción de la función...
     * 
     * @param show 
     */
    public void createShowSesions(Show show){

        try{
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            PreparedStatement ps = connection.prepareStatement("INSERT INTO `ShowSesion` values(?,?,?,?)");

                for(ShowSesion showSesion: show.getSesions()){

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = format.format(showSesion.getDate().getTime());

                    ps.setNull(1, 0);
                    ps.setString(2, show.getUuid().toString());
                    ps.setString(3, formattedDate);
                    ps.setInt(4, showSesion.getTickets());

                    ps.executeUpdate();
                }

                if (ps != null){ 
                    ps.close(); 
                }

                connection.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    
    /** 
     * Función que se encarga de buscar y devolver de la base de datos los shows que coincidan con la el título recibido en la función.
     * 
     * @param title Título de la función de la se quieren buscar los shows.
     * @return Show Objeto show que se devuelve al encontrar relación con el título recibido en la función.
     */
    public Show getShowByTitle(String title) {

        Show show = new Show();

        try{

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            Statement statement = connection.createStatement();

            String sqlString = "select s.id, s.title, s.description, s.category, s.capacity from `Show` s where s.title = '" + title + "'";
            ResultSet rs = statement.executeQuery(sqlString);

            while (rs.next()) {

                show.setID(rs.getString("s.id"));
                show.setTitle(rs.getString("s.title"));
                show.setDescription(rs.getString("s.description"));
                show.setCategory(rs.getString("s.category"));
                show.setCapacity(rs.getInt("s.capacity"));

            }

            String sqlString2 = "select ss.date, ss.tickets from `ShowSesion` ss where ss.showId = '" + show.getUuid() + "'";
            rs = statement.executeQuery(sqlString2);

            while(rs.next()){

                Date date = new Date(rs.getDate("date").getTime());
                Calendar calendarDate = new GregorianCalendar();
                calendarDate.setTime(date);

                show.addSesion(calendarDate, rs.getInt("ss.tickets"));
            }
            if (statement != null) statement.close();

            return show;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    /** 
     * Función que busca y devuelve de la base de datos todos los shows del sistema.
     * 
     * @return ArrayList<Show> Lista de shows que se han encontrado en la base de datos.
     */
    public ArrayList<Show> getAllShows() {
        
        ArrayList<Show> shows = new ArrayList<Show>();

        try{

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            Statement statement = connection.createStatement();

            String sqlString = "select s.id, s.title, s.description, s.category, s.capacity from `Show` s";
            ResultSet rs = statement.executeQuery(sqlString);

            while (rs.next()) {

                Show show = new Show();

                show.setID(rs.getString("s.id"));
                show.setTitle(rs.getString("s.title"));
                show.setDescription(rs.getString("s.description"));
                show.setCategory(rs.getString("s.category"));
                show.setCapacity(rs.getInt("s.capacity"));
                
                shows.add(show);
            }

            for(Show i: shows){

                String sqlString2 = "select ss.date, ss.tickets from `ShowSesion` ss where ss.showId = '" + i.getUuid() + "'";
                rs = statement.executeQuery(sqlString2);

                while(rs.next()){

                    Date date = new Date(rs.getDate("date").getTime());
                    Calendar calendarDate = new GregorianCalendar();
                    calendarDate.setTime(date);

                    i.addSesion(calendarDate, rs.getInt("ss.tickets"));
                }
            }

            if (statement != null) statement.close();

            return shows;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
        
    }
    
}
