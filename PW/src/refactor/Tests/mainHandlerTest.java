package refactor.Tests;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import refactor.MainHandler;
import refactor.Repository.UserRepository;

public class mainHandlerTest {

    @Test
    void testMainHandlerRegisterUser() throws IOException, ClassNotFoundException, SQLException{

        UserRepository userRepository = new UserRepository();
        userRepository.saveUser("name", "lastName", "nickName", "mail"); //will add it

        MainHandler.getHandler().registerUser("x", "x", "x", "xxy"); //shouldnt as it was added before

    }
}
