package refactor.Tests;

import org.junit.jupiter.api.Test;

import refactor.DAOs.UserDAO;
import refactor.Model.Entities.User;

public class userDAOTest {

    User user = new User("name", "lastName", "nickName", "mail");
    UserDAO userDAO = new UserDAO();

    @Test
    void createUser() {
        
        userDAO.create(user);

    }

    @Test
    void deleteUser() {
        
        userDAO.delete(user);

    }
}
