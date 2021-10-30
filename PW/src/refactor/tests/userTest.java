package refactor.tests;

import refactor.model.Entities.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class userTest {

    @Test
    void constructorAndGettersTest(){

        User user = new User("name", "lastName", "nickName", "mail");

        assertEquals(user.getName(), "name");
        assertEquals(user.getLastName(), "lastName");
        assertEquals(user.getNickName(), "nickName");
        assertEquals(user.getMail(), "mail");

        assertNotEquals(user.getUuid(), 1);
    }

    @Test
    void settersTest(){

        User user = new User("name", "lastName", "nickName", "mail");

        assertEquals(user.getName(), "name");
        assertEquals(user.getLastName(), "lastName");
        assertEquals(user.getNickName(), "nickName");
        assertEquals(user.getMail(), "mail");

        user.setName("newname");
        user.setLastName("newlastName");
        user.setNickName("newnickName");
        user.setMail("newmail");

        assertEquals(user.getName(), "newname");
        assertEquals(user.getLastName(), "newlastName");
        assertEquals(user.getNickName(), "newnickName");
        assertEquals(user.getMail(), "newmail");

    }

    @Test
    void roleTest(){

        User user = new User("name", "lastName", "nickName", "mail");

        assertEquals(user.getRole(), "VIEWER");
        assertNotEquals(user.getRole(), "ADMIN");

        user.setRoleAdmin();
        assertEquals(user.getRole(), "ADMIN");
        assertNotEquals(user.getRole(), "VIEWER");

        user.setRoleViewer();
        assertEquals(user.getRole(), "VIEWER");
        assertNotEquals(user.getRole(), "ADMIN");
    }
    
}
