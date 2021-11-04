package refactor.Tests;

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
    }
}
