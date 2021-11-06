package refactor.Repository.DAOs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import refactor.Model.Entities.User;

public class UserDAO {

    public void create(User user) throws IOException {

        try{
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO User values(?,?,?,?,?,?)");

                ps.setString(1,user.getUuid().toString());
                ps.setString(2,user.getName());
                ps.setString(3,user.getLastName());
                ps.setString(4,user.getNickName());
                ps.setString(5,user.getMail());
                ps.setString(6,user.getRole());

                ps.executeUpdate();

                if (ps != null){ 
                    ps.close(); 
                }
                connection.close();

        } catch (Exception e){
            System.out.println(e);
        }

        String path = System.getProperty("user.dir") + File.separator + "src/refactor/Repository/users.txt";

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(path), ("User").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getUuid().toString().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getLastName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getNickName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getMail().getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);
    }

    public User getUserById(UUID userId){

        User user = new User();

        try{

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            Statement statement = connection.createStatement();

            String sqlString = "select u.id, u.name, u.lastname, u.nickname, u.mail, u.role from `User` u where u.id = '" + userId + "'";
            ResultSet rs = statement.executeQuery(sqlString);

            while (rs.next()) {

                user.setID(rs.getString("u.id"));
                user.setName(rs.getString("u.name"));
                user.setLastName(rs.getString("u.lastname"));
                user.setNickName(rs.getString("u.nickname"));
                user.setMail(rs.getString("u.mail"));
                if(rs.getString("u.role")=="ADMIN"){user.setRoleAdmin();}
            }
            if (statement != null) statement.close();
            return user;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    /**
	 * 
	 * @return User instance if found; null if not
	 */
    public User getUserByMail(String mail){

        User user = new User();

        try{

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            Statement statement = connection.createStatement();

            String sqlString = "select u.id, u.name, u.lastname, u.nickname, u.mail, u.role from `User` u where u.mail = '" + mail + "'";
            ResultSet rs = statement.executeQuery(sqlString);

            while (rs.next()) {

                user.setID(rs.getString("u.id"));
                user.setName(rs.getString("u.name"));
                user.setLastName(rs.getString("u.lastname"));
                user.setNickName(rs.getString("u.nickname"));
                user.setMail(rs.getString("u.mail"));
                if(rs.getString("u.role")=="ADMIN"){user.setRoleAdmin();}
            }
            if (statement != null) statement.close();
            return user;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {    

        ArrayList<User> userList = new ArrayList<User>();

        try{

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            Statement statement = connection.createStatement();

            String sqlString = "SELECT * FROM User u";
            ResultSet rs = statement.executeQuery(sqlString);

            while (rs.next()) {

                User user = new User();
                user.setID(rs.getString("u.id"));
                user.setName(rs.getString("u.name"));
                user.setLastName(rs.getString("u.lastname"));
                user.setNickName(rs.getString("u.nickname"));
                user.setMail(rs.getString("u.mail"));
                if(rs.getString("u.role")=="ADMIN"){user.setRoleAdmin();}
                userList.add(user);
            }
            if (statement != null) statement.close();
            return userList;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public void delete(User user) {

        try {
            Connection connection = null;

            Class.forName("com.mysql.jdbc.Driver");

            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            PreparedStatement ps = connection.prepareStatement("DELETE FROM User WHERE id = ?");

            ps.setString(1, user.getUuid().toString());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserName(UUID id, String newName) {

        try {
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            String sql = "UPDATE User SET name = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, newName);
            ps.setString(2, id.toString());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserLastName(UUID id, String newLastName) {

        try {
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            String sql = "UPDATE User SET lastname = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, newLastName);
            ps.setString(2, id.toString());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserNickName(UUID id, String newNickName) {

        try {
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            String sql = "UPDATE User SET nickname = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, newNickName);
            ps.setString(2, id.toString());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserMail(UUID id, String newMail) {

        try {
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            String sql = "UPDATE User SET mail = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, newMail);
            ps.setString(2, id.toString());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}