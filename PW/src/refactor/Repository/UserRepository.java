package refactor.Repository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import refactor.Model.Entities.User;
import refactor.Repository.DAOs.UserDAO;

public class UserRepository {

    public UserRepository(){}

    public void saveViewer(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException {

        User user = new User(name, lastName, nickName, mail);
        
        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    }
    
    public void saveAdmin(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException {

        User user = new User(name, lastName, nickName, mail);
        user.setRoleAdmin();

        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    } 

    public User getUserById(UUID userId){

        UserDAO userDAO = new UserDAO();
        return userDAO.getUserById(userId);
    }

    public Boolean anyUserWithMail(String mail){

        UserDAO userDAO = new UserDAO();

        if( userDAO.getUserByMail(mail).getUuid() != null ){

            return true;
        }

        return false;
    }

    public User getUserByMail(String mail){

        UserDAO userDAO = new UserDAO();

        return userDAO.getUserByMail(mail);
    }

    public void updateUserName(UUID id, String newName) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserName(id, newName);
    }

    public void updateUserLastName(UUID id, String newLastName) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserLastName(id, newLastName);
    }

    public void updateUserNickName(UUID id, String newNickName) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserNickName(id, newNickName);
    }

    public void updateUserMail(UUID id, String newMail) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserMail(id, newMail);
    }

    public void deleteUserByMail(String mail){

        UserDAO userDAO = new UserDAO();

        User user = userDAO.getUserByMail(mail);

        userDAO.delete(user);
    }
}
