package Handlers;

import Model.Entities.User.User;

/**
 * Interfaz publica del handler del user
 * @author Javier De Santiago Palomino
 */
public interface UserHandlerInterface {
    
    void createUser(String name);

    void deleteUser(User user);

    User getUser(Integer id);

    void updateUser(User user);
}
