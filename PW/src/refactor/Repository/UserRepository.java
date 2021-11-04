package refactor.Repository;

import java.io.IOException;
import java.sql.SQLException;

import refactor.Model.Entities.User;
import refactor.Repository.DAOs.UserDAO;

public class UserRepository {

    public UserRepository(){}

    public void saveUser(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException {

        User user = new User(name, lastName, nickName, mail);
        
        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    }    

    public Boolean isUserRegistered(String mail){

        UserDAO userDAO = new UserDAO();

        if( userDAO.getUserByMail(mail).getUuid() != null ){

            return true;
        }

        return false;
    }

}
