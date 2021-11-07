package refactor.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import refactor.MainHandler;
import refactor.Repository.UserRepository;
import refactor.Repository.DAOs.UserDAO;

public class mainHandlerTest {

    @Test
    void testMainHandlerUserMethods() throws IOException, ClassNotFoundException, SQLException{

        UserDAO userDAO = new UserDAO();

        String nameString1     = UUID.randomUUID().toString();
        String lastNameString1 = UUID.randomUUID().toString();
        String nickNameString1 = UUID.randomUUID().toString();
        String mailString1      = UUID.randomUUID().toString();

        String nameString2     = UUID.randomUUID().toString();
        String lastNameString2 = UUID.randomUUID().toString();
        String nickNameString2 = UUID.randomUUID().toString();
        String mailString2      = UUID.randomUUID().toString();


        MainHandler.getHandler().registerViewer(nameString1, lastNameString1, nickNameString1, mailString1);
        MainHandler.getHandler().registerAdmin(nameString2, lastNameString2, nickNameString2, mailString2);

        assertEquals(userDAO.getUserByMail(mailString1).getName(), nameString1);
        
        MainHandler.getHandler().registerViewer("name", "lastName", "nickName", mailString1); //should not
        MainHandler.getHandler().registerViewer("name", "lastName", "nickName", mailString2); //should not

        MainHandler.getHandler().deleteUser(mailString2);

        assertEquals(userDAO.getUserByMail(mailString2).getName(), null);

        MainHandler.getHandler().registerViewer("name", "lastName", "nickName", mailString2); //should 

        MainHandler.getHandler().updateUserData(mailString1, "name", "lastName", nickNameString1, "mail");   

        assertEquals(userDAO.getUserByMail(mailString1).getName(), null);
        assertEquals(userDAO.getUserByMail("mail").getName(), "name");

    }
}
