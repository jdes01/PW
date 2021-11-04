package refactor.DAOs;

import java.sql.*;
import java.util.ArrayList;

import refactor.Model.Entities.User;

public class UserDAO {
    
    public void create(User user) {    
        
        try{

            Connection connection = null;

            //System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");


            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            //PreparedStatement ps = connection.prepareStatement("INSERT INTO User (id,name,lastname,nickname,mail) values(?,?,?,?)");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO User values(?,?,?,?,?,?)");

                ps.setString(1,user.getUuid().toString());
                ps.setString(2,user.getName());
                ps.setString(3,user.getLastName());
                ps.setString(4,user.getNickName());
                ps.setString(5,user.getMail());
                ps.setString(6,user.getRole());

                ps.executeUpdate();

        } catch (Exception e){

            System.out.println(e);
        }
        
    }

    public void update(User user) {

        try {
            Connection connection = null;

            Class.forName("com.mysql.jdbc.Driver");

            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            String sql = "UPDATE User WHERE id = ? SET ";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1,user.getUuid().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(User user) {

        try {
            Connection connection = null;

            Class.forName("com.mysql.jdbc.Driver");

            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            PreparedStatement ps = connection.prepareStatement("DELETE FROM User WHERE nick = ?");

            ps.setString(1, user.getNickName());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
