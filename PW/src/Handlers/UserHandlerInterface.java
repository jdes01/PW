package Handlers;

import java.io.IOException;

import Model.Entities.User;

/**
 * Interfaz publica del handler del user
 * @author Javier De Santiago Palomino
 */
public interface UserHandlerInterface {
    
    void createUser();

    void updateUser() throws ClassNotFoundException, IOException;
}
