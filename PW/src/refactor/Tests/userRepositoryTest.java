package refactor.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import refactor.Model.Entities.User;
import refactor.Repository.UserRepository;
import refactor.Repository.DAOs.UserDAO;

public class userRepositoryTest {

    @Test
    void isUserRegisteredTest() throws IOException, NullPointerException{

        String randomName1 = UUID.randomUUID().toString();
        String randomName2 = UUID.randomUUID().toString();
        String randomMail1 = UUID.randomUUID().toString();
        String randomMail2 = UUID.randomUUID().toString();

        User userx = new User(randomName1, "x", "x", randomMail1);
        User usery = new User(randomName2, "y", "y", randomMail2);
        UserDAO userDAO = new UserDAO();
        userDAO.create(userx);
        userDAO.create(usery);

        //assertEquals(userRepository.isUserRegistered("mail"), true);
        assertEquals(userDAO.getUserByMail(randomMail1).getName(), randomName1);
        assertEquals(userDAO.getUserByMail(randomMail2).getName(), randomName2);
    }

    @Test 
    void anyUserWithMailTest() throws IOException{

        UUID randomMail = UUID.randomUUID();

        User userz = new User("zname", "z", "z", randomMail.toString());

        UserDAO userDAO = new UserDAO();
        userDAO.create(userz);

        UserRepository userRepository = new UserRepository();
        assertEquals(userRepository.anyUserWithMail(randomMail.toString()), true); 

    }

}
