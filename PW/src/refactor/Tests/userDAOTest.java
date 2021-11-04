package refactor.Tests;

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

    }
}
