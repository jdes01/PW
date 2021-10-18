package Handlers;

import Model.Entities.User.User;

/**
 * Interfaz publica del handler del user
 * @author Javier De Santiago Palomino
 */
public interface UserHandlerInterface {
    
    void createUser(String name);

    void updateUser(User user);
}
