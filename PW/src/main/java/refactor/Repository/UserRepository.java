package refactor.Repository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import refactor.Model.Entities.User;
import refactor.Repository.DAOs.UserDAO;

/**
 * Clase repositorio de los usuarios
 * 
 * @author Javier De Santiago Palomino
 */

public class UserRepository {

    /**
     * Constructor de UserRepository
     */

    public UserRepository(){}

    
    /** 
     * Funcion para guardar a un viewer
     * 
     * @param name Nombre del usuario
     * @param lastName Apellido del usuario
     * @param nickName Nick del usuario
     * @param mail Mail del usuario
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:<p>
        The forName method in class Class<p>
        The findSystemClass method in class ClassLoader<p>
        The loadClass method in class ClassLoader
     * @throws SQLException An exception that provides information on a database access error or other errors. 
     */

    public void saveViewer(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException {

        User user = new User(name, lastName, nickName, mail);

        Calendar c = Calendar.getInstance();
        user.setRegiserDate(c);
        user.setLastLoginDate(c);
        
        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    }
    
    
    /** 
     * Funcion para guardar un administrador
     * 
     * @param name Nombre del administrador
     * @param lastName Apellido del administrador
     * @param nickName Nick del administrador
     * @param mail Mail del administrador
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:<p>
        The forName method in class Class<p>
        The findSystemClass method in class ClassLoader<p>
        The loadClass method in class ClassLoader
     * @throws SQLException An exception that provides information on a database access error or other errors. 
     */

    public void saveAdmin(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException {

        User user = new User(name, lastName, nickName, mail);
        user.setRoleAdmin();

        Calendar c = Calendar.getInstance();
        user.setRegiserDate(c);
        user.setLastLoginDate(c);

        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    } 

    
    /** 
     * Funcion getter del usuario a parti de su ID
     * 
     * @param userId ID del usuario
     * @return User
     */

    public User getUserById(UUID userId){

        UserDAO userDAO = new UserDAO();
        return userDAO.getUserById(userId);
    }

    
    /** 
     * Funcion para comprobar la existencia del mail de un usuario
     * 
     * @param mail Mail del usuario
     * @return Boolean
     */

    public Boolean anyUserWithMail(String mail){

        UserDAO userDAO = new UserDAO();

        if( userDAO.getUserByMail(mail).getUuid() != null ){

            return true;
        }

        return false;
    }

    
    /** 
     * Funcion getter del usuario a partir de su mail
     * 
     * @param mail Mail del usuario
     * @return User
     */

    public User getUserByMail(String mail){

        UserDAO userDAO = new UserDAO();

        return userDAO.getUserByMail(mail);
    }

    
    /** 
     * Funcion para actualziar el nombre del usuario
     * 
     * @param id ID del usuario
     * @param newName Nuevo nombre del usuario
     */

    public void updateUserName(UUID id, String newName) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserName(id, newName);
    }

    
    /** 
     * Funcion para actualizar el apellido del usuario
     * 
     * @param id ID del usuario
     * @param newLastName Nuevo apellido del usuario
     */

    public void updateUserLastName(UUID id, String newLastName) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserLastName(id, newLastName);
    }

    
    /** 
     * Funcion para actualziar el nick del usuario
     * 
     * @param id ID del usuario
     * @param newNickName Nuevo nick del usuario
     */

    public void updateUserNickName(UUID id, String newNickName) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserNickName(id, newNickName);
    }

    
    /** 
     * Funcion para actualizar el mail del usuario
     * 
     * @param id ID del usuario
     * @param newMail Nuevo mail del usuario
     */

    public void updateUserMail(UUID id, String newMail) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserMail(id, newMail);
    }

    
    /** 
     * Funcion para borrar un usuario a partir de su mail
     * 
     * @param mail Mail del usuario
     */

    public void deleteUserByMail(String mail){

        UserDAO userDAO = new UserDAO();

        User user = userDAO.getUserByMail(mail);

        userDAO.delete(user);
    }


    public void updateLastLoginDateByMail(String mail){

        UserDAO userDAO = new UserDAO();

        userDAO.updateLastLoginDateByMail(mail);
    }


    public ArrayList<String> getAllUsersMails() {

        UserDAO userDAO = new UserDAO();

        ArrayList<String> allUsers = new ArrayList<>();

        for(User user: userDAO.getAllUsers()){

            allUsers.add(user.getMail());
        }

        return allUsers;
    }

    public ArrayList<User> getAllUsers(){

        UserDAO userDAO = new UserDAO();

        return userDAO.getAllUsers();
    }

    public ArrayList<String> getAllNickNames() {

        UserDAO userDAO = new UserDAO();

        ArrayList<String> allNickNames = new ArrayList<>();

        for(User user: userDAO.getAllUsers()){

            allNickNames.add(user.getNickName());
        }

        return allNickNames;
    }
}