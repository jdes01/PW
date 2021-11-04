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
import java.util.UUID;

import refactor.Model.Entities.User;

public class UserDAO {

    public static void create(User user) throws IOException {

        try{
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO User values(?,?,?,?,?,?)");

                ps.setString(1,user.getUuid().toString());
                ps.setString(2,user.getName());
                ps.setString(3,user.getLastName());
                ps.setString(4,user.getMail());
                ps.setString(5,user.getNickName());
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

    public static User getUserById(UUID userId){

        try{
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            java.sql.Statement statement = connection.createStatement();
            String query = "SELECT id, name, lastname, nickname, mail, role FROM Users WHERE id = " + userId;
            ResultSet resultSet = (ResultSet) statement.executeQuery(query);

            User user = new User("name", "lastname", "nickName", "mail");

            while (resultSet.next()) {

                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setNickName(resultSet.getString("nickname"));
                user.setMail(resultSet.getString("mail"));

                if(resultSet.getString("role") == "ADMIN"){user.setRoleAdmin();}
                user.setUUID(resultSet.getString("Id"));
			}

            if (statement != null){ 
                statement.close(); 
            }
            connection.close();

            return user;

        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}