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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import refactor.Model.Entities.User;

/**
 * Clase que se encarga de gestionar en la base de datos toda la información relacionada con los usuarios.
 * 
 * @author Javier De Santiago Palomino
 */
public class UserDAO {

    
    /** 
     * Función que se encarga de añadir un nuevo usuario que se recibe como parámetro a la base de datos.
     * 
     * @param user Objeto User que se quiere introducir a la base de datos.
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    public void create(User user) throws IOException {

        try{
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO User values(?,?,?,?,?,?,?,?)");

                ps.setString(1,user.getUuid().toString());
                ps.setString(2,user.getName());
                ps.setString(3,user.getLastName());
                ps.setString(4,user.getNickName());
                ps.setString(5,user.getMail());
                ps.setString(6,user.getRole());

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String formattedRegisterDate = format.format(user.getRegisterDate().getTime());
                String formattedLastLoginDate = format.format(user.getLastLoginDate().getTime());

                ps.setString(7, formattedRegisterDate);
                ps.setString(8, formattedLastLoginDate);

                ps.executeUpdate();

                if (ps != null){ 
                    ps.close(); 
                }
                connection.close();

        } catch (Exception e){
            System.out.println(e);
        }

        /*String path = System.getProperty("user.dir") + File.separator + "src/refactor/Repository/users.txt";

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

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);*/
    }

    
    /** 
     * Función que se encarga de devolver el usuario que coincide con el id que se pasa cómo parámetro.
     * 
     * @param userId Id del usuario que se quiere buscar en la base de datos.
     * @return User Objeto usuario que coincide con el id pasado cómo parámetro. Se devolverá un NULL si no se encuentra.
     */
    public User getUserById(UUID userId){

        User user = new User();

        try{

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            Statement statement = connection.createStatement();

            String sqlString = "select u.id, u.name, u.lastname, u.nickname, u.mail, u.role, u.registerDate, u.lastLoginDate from `User` u where u.id = '" + userId + "'";
            ResultSet rs = statement.executeQuery(sqlString);

            while (rs.next()) {

                user.setID(rs.getString("u.id"));
                user.setName(rs.getString("u.name"));
                user.setLastName(rs.getString("u.lastname"));
                user.setNickName(rs.getString("u.nickname"));
                user.setMail(rs.getString("u.mail"));
                if(rs.getString("u.role")=="ADMIN"){user.setRoleAdmin();}

                Calendar c1 = Calendar.getInstance();
                c1.setTime(rs.getDate("u.registerDate"));
                user.setRegiserDate( c1 );

                Calendar c2 = Calendar.getInstance();
                c2.setTime(rs.getDate("u.lastLoginDate"));
                user.setLastLoginDate( c2 );
            }
            if (statement != null) statement.close();
            return user;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    /**
     * Función que se encarga de devolver de la base de datos el usuario asociado al correo que se recibe cómo parámetro.
     * 
	 * @param mail Correo del usuario que se quiere buscar en la base de datos.
	 * @return Instancia de usuario asociada al mail que se recibe cómo párametro. Se devuelve un NULL si no se encuentra.
	 */
    public User getUserByMail(String mail){

        User user = new User();

        try{

            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");
            Statement statement = connection.createStatement();

            String sqlString = "select u.id, u.name, u.lastname, u.nickname, u.mail, u.role, u.registerDate, u.lastLoginDate from `User` u where u.mail = '" + mail + "'";
            ResultSet rs = statement.executeQuery(sqlString);

            while (rs.next()) {

                user.setID(rs.getString("u.id"));
                user.setName(rs.getString("u.name"));
                user.setLastName(rs.getString("u.lastname"));
                user.setNickName(rs.getString("u.nickname"));
                user.setMail(rs.getString("u.mail"));
                if(rs.getString("u.role").contentEquals("ADMIN")) {
                	user.setRoleAdmin();
                } else if(rs.getString("u.role").contentEquals("VIEWER")) {
                	user.setRoleViewer();
                }

                Calendar c1 = Calendar.getInstance();
                c1.setTime(rs.getDate("u.registerDate"));
                user.setRegiserDate( c1 );

                Calendar c2 = Calendar.getInstance();
                c2.setTime(rs.getDate("u.lastLoginDate"));
                user.setLastLoginDate( c2 );
            }
            if (statement != null) statement.close();
            return user;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    /** 
     * Función que se encarga de devolver en una lista todos los usuarios que se encuentran en la base de datos.
     * 
     * @return ArrayList<User> Lista de usuarios que se ha encontrado en la base de datos.
     */
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
                if(rs.getString("u.role").contentEquals("ADMIN")) {
                	user.setRoleAdmin();
                } else if(rs.getString("u.role").contentEquals("VIEWER")) {
                	user.setRoleViewer();
                }

                Calendar c1 = Calendar.getInstance();
                c1.setTime(rs.getDate("u.registerDate"));
                user.setRegiserDate( c1 );

                Calendar c2 = Calendar.getInstance();
                c2.setTime(rs.getDate("u.lastLoginDate"));
                user.setLastLoginDate( c2 );

                userList.add(user);
            }
            if (statement != null) statement.close();
            return userList;
            
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    /** 
     * Función que se encarga de eliminar la instancia de user pasada cómo parámetro de la base de datos.
     * 
     * @param user Instancia de user que se quiere eliminar de la base de datos.
     */
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

    
    /** 
     * Función que se encarga de sustituir en la base de datos el nombre de una instancia de usuario asociada al id pasado cómo parámetro por el de newName.
     * 
     * @param id Id del usuario al que se le quiere cambiar el nombre.
     * @param newName Nuevo nombre que se le quiere poner al usuario con el id especificado cómo parámetro.
     */
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

    
    /** 
     * Función que se encarga de sustituir en la base de datos el apellido de una instancia de usuario asociada al id pasado cómo parámetro por el de newLastName.
     * 
     * @param id Id asociada a la instancia de usuario al que se le quiere cambiar el apellido.
     * @param newLastName Nuevo apellido que se le quiere atribuir a la instancia de usuario especificada en el id.
     */
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

    
    /** 
     * Función que se encarga de sustituir en la base de datos el apodo de una instancia de usuario asociada al id pasado cómo parámetro por el de newNickName.
     * 
     * @param id Id asociada a la instancia de usuario al que se le quiere cambiar el apodo.
     * @param newNickName Nuevo apodo que se le quiere atribuir a la instancia de usuario especificada en el id.
     */
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

    
    /** 
     * Función que se encarga de sustituir en la base de datos el correo de una instancia de usuario asociada al id pasado cómo parámetro por el de newMail.
     * 
     * @param id Id asociada a la instancia de usuario al que se le quiere cambiar el apodo.
     * @param newMail Nuevo correo que se le quiere atribuir a la instancia de usuario especificada en el id.
     */
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


    public void updateLastLoginDateByMail(String mail) {

        try {
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i92sanpj","i92sanpj","1234pw2122");

            String sql = "UPDATE User SET lastLoginDate = ? WHERE mail = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            Calendar c = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String lastLoginDate = format.format(c.getTime());

            ps.setString(1, lastLoginDate);
            ps.setString(2, mail);

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}