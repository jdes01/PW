package refactor.Repository.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import refactor.Model.Entities.Review;
import refactor.Model.ValueObjects.UserScore;

/**
 * DAO encargado de escribir en la base de datos toda la información relacionada con las reviews del sistema.
 * 
 * @author Alberto Cano Turnes
 */
public class ReviewDAO {
    
    /**
     * Constuctor de la clase ReviewDAO.
     */
    public ReviewDAO(){}

    /** 
     * Función que se encarga de añadir una nueva review en la base de datos.
     *
     * @param review Objeto review que se quiere añadir a la base de datos.
     */
    public void createReview(Review review) {

        try{
            Connection connection = null;
            Connection connection2 = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            connection2 = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `Review` values(?,?,?,?,?,?)");

                ps.setString(1, review.getId().toString());
                ps.setString(2, review.getTitle());
                ps.setString(3, review.getText());
                ps.setString(4, review.getUser().getUuid().toString());
                ps.setString(5, review.getShow().getUuid().toString());
                ps.setInt(6, review.getScore().getScore());

                ps.executeUpdate();

            PreparedStatement ps2 = connection2.prepareStatement("INSERT INTO `ReviewUserRating` values(?,?,?)");

            for(UserScore userScore: review.getUserRatings()){

                ps2.setString(1, review.getId().toString());
                ps2.setString(2, userScore.getUser().getUuid().toString());
                ps2.setInt(3, userScore.getScore().getScore());

                ps2.executeUpdate();
            }

            if (ps != null){ 
                ps.close(); 
            }
            connection.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }
    
}
