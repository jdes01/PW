package refactor.Tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import refactor.Model.Entities.User;
import refactor.Repository.DAOs.UserDAO;

public class userRepositoryTest {

    @Test
    void isUserRegisteredTest() throws IOException, NullPointerException{

        User userx = new User("xname", "x", "x", "x");
        User usery = new User("yname", "y", "y", "y");
        UserDAO userDAO = new UserDAO();
        userDAO.create(userx);
        userDAO.create(usery);

        //assertEquals(userRepository.isUserRegistered("mail"), true);
        assertEquals(userDAO.getUserByMail("x").getName(), "xname");
        assertEquals(userDAO.getUserByMail("y").getName(), "yname");
    }
}
