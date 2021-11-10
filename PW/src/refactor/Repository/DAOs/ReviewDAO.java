package refactor.Repository.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import refactor.Model.Entities.Review;
import refactor.Model.Entities.User;
import refactor.Model.ValueObjects.Score;
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


    
    public ArrayList<Review> getAllReviews() {

        ArrayList<Review> reviews = new ArrayList<Review>();

        try{

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            Statement statement = connection.createStatement();

            String sqlString = "SELECT * FROM Review r";
            ResultSet rs = statement.executeQuery(sqlString);

            while (rs.next()) {

                Review review = new Review();
                review.setTitle(rs.getString("r.title"));
                review.setText(rs.getString("r.text"));
                Score score = new Score(rs.getInt("r.score"));
                review.setScore(score);

                UserDAO userDAO = new UserDAO();
                UUID userId = UUID.fromString(rs.getString("r.userId"));
                review.setUser(userDAO.getUserById(userId));

                ShowDAO showDAO = new ShowDAO();
                UUID showId = UUID.fromString(rs.getString("r.showId"));
                review.setShow(showDAO.getShowById(showId));

                    String sqlString2 = "SELECT * FROM `ReviewUserRating` rur WHERE rur.reviewId = '" + rs.getString("r.id") + "'";
                    ResultSet rs2 = statement.executeQuery(sqlString2);

                    while(rs2.next()){

                        User x = userDAO.getUserById( UUID.fromString(rs2.getString("rur.userId")) );
                        Score xscore = new Score(rs2.getInt("rur.score"));

                        review.addUserRating(x, xscore);
                    }

                reviews.add(review);
            }
            if (statement != null) statement.close();
            return reviews;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    
}
