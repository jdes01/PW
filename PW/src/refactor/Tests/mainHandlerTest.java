package refactor.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import refactor.MainHandler;

public class mainHandlerTest {

    @Test
    void testMainHandlerRegisterUser() throws IOException, ClassNotFoundException, SQLException{

        MainHandler.getHandler().registerUser("name", "lastName", "nickName", "mail");

    }
}
