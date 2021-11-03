package refactor.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import refactor.MainHandler;

public class mainHandlerTest {

    @Test
    void testMainHandlerRegisterUser() throws IOException{

        MainHandler.getHandler().registerUser("name", "lastName", "nickName", "mail");

    }
}
