package refactor.Repository.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.ShowSesion;

public class ShowDAO {
    
    public ShowDAO(){}

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
    
}
