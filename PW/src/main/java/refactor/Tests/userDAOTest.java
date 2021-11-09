package refactor.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import refactor.Model.Entities.User;
import refactor.Repository.UserRepository;
import refactor.Repository.DAOs.UserDAO;

public class userDAOTest {

    @Test
    void createUser() throws IOException {

        User user = new User("name", "lastName", "nickName", "mail");
        user.setRegiserDate(Calendar.getInstance());
        user.setLastLoginDate(Calendar.getInstance());
        UserDAO userDAO = new UserDAO();
        
        userDAO.create(user);

    }

    /*@Test
    void deleteUser() throws IOException {
        
        User UsertobeDeleted = new User("User", "to be Deleted", "UsertobeDeleted", "user@deleted.com");
        ArrayList<User> users = new ArrayList<User>();

        userDAO.create(UsertobeDeleted);
        users = userDAO.read();
        for(User user : users) {
            if(user.getMail().equals(UsertobeDeleted.getMail())) {
                assertEquals(user.getUuid(), UsertobeDeleted.getUuid());
            }
        }
        userDAO.delete(UsertobeDeleted);
        users = userDAO.read();
        for(User user : users) {
            assertNotEquals(user.getUuid(), UsertobeDeleted.getUuid());
        }

    }*/

    @Test
    void getAllUsers() throws NullPointerException{
        
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.getAllUsers();

        UserRepository userRepository = new UserRepository();

        for(User user: users){

            assertEquals(userRepository.anyUserWithMail(user.getMail()), true);
        }

    }

    @Test
    void deleteUserTest() throws NullPointerException, IOException{
        
        UserDAO userDAO = new UserDAO();

        User user1 = new User("name", "lastName", "nickName", "mail");
        User user2 = new User("name", "lastName", "nickName", "mai2");
        User user3 = new User("name", "lastName", "nickName", "mai3");

        userDAO.create(user1);
        userDAO.create(user2);
        userDAO.create(user3);

        userDAO.delete(user2);
        UserRepository userRepository = new UserRepository();
        userRepository.deleteUserByMail("mail");

        //should only survive user3

    }
}
