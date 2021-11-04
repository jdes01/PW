package refactor.Tests;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import refactor.Model.Entities.User;
import refactor.Repository.UserRepository;

public class userDAOTest {
    
    @Test
    void getUserByIDTest() throws IOException, ClassNotFoundException, SQLException, NullPointerException {

        User user = new User("xxx", "xxx", "xxx", "xxx");
        UserRepository userRepository = new UserRepository();
        userRepository.saveUser(user);

        User user2 = userRepository.getUserById(user.getUuid());

        assertEquals(user2.getName(), user.getName());
        assertEquals(user2.getLastName(), user.getLastName());
        assertEquals(user2.getMail(), user.getMail());
        assertEquals(user2.getNickName(), user.getNickName());
        assertEquals(user2.getRole(), user.getRole());
        assertEquals(user2.getUuid(), user.getUuid());
=======
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    }

    @Test
    void readUsers() {
        
        ArrayList<User> users = userDAO.read();

        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getName() + " " + users.get(i).getUuid());
        }

>>>>>>> 0589e4d557dbea8d1f5ef4d6033ac0d471106d21
    }
}
