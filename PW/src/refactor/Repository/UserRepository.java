package refactor.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import refactor.Model.Entities.User;

public class UserRepository {

    private String path = System.getProperty("user.dir") + File.separator + "src/refactor/Repository/users.txt";

    public UserRepository(){}

    public void saveUser(User user) throws IOException, ClassNotFoundException, SQLException {

        ////////////////////////////////////////////////////////////////////////

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
                ps.setString(4,user.getMail());
                ps.setString(5,user.getNickName());
                ps.setString(6,user.getRole());

                ps.executeUpdate();

        } catch (Exception e){

            System.out.println(e);
        }


        ////////////////////////////////////////////////////////////////////////

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
}
