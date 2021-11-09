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


    @Test 
    void getUserById() throws IOException{

        String randomName = UUID.randomUUID().toString();
        String randomLastName = UUID.randomUUID().toString();
        String randomNickName = UUID.randomUUID().toString();
        String randomMail = UUID.randomUUID().toString();

        User user = new User(randomName, randomLastName, randomNickName, randomMail);
        UserDAO userDAO = new UserDAO();
        userDAO.create(user);

        UserRepository userRepository = new UserRepository();

        User returnedUser = userRepository.getUserById(user.getUuid());

        assertEquals(returnedUser.getName(), randomName);
    }

    @Test 
    void updateUserDataTest() throws IOException{

        String randomName = UUID.randomUUID().toString();
        String randomLastName = UUID.randomUUID().toString();
        String randomNickName = UUID.randomUUID().toString();
        String randomMail = UUID.randomUUID().toString();

        User user = new User(randomName, randomLastName, randomNickName, randomMail);
        UserDAO userDAO = new UserDAO();
        userDAO.create(user);

        String newName = UUID.randomUUID().toString();
        String newLastName = UUID.randomUUID().toString();
        String newNickName = UUID.randomUUID().toString();
        String newMail = UUID.randomUUID().toString();

        UserRepository userRepository = new UserRepository();

        userRepository.updateUserName(user.getUuid(), newName);
        userRepository.updateUserLastName(user.getUuid(), newLastName);
        userRepository.updateUserNickName(user.getUuid(), newNickName);
        userRepository.updateUserMail(user.getUuid(), newMail);

        assertEquals(userRepository.getUserById(user.getUuid()).getName(), newName);
        assertEquals(userRepository.getUserById(user.getUuid()).getLastName(), newLastName);
        assertEquals(userRepository.getUserById(user.getUuid()).getNickName(), newNickName);
        assertEquals(userRepository.getUserById(user.getUuid()).getMail(), newMail);
    }
}
