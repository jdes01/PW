package Handlers;

import Model.Entities.User.User;

public interface UserHandlerInterface {
    
    void createUser(String name);

    void deleteUser(User user);

    User getUser(Integer id);

    void updateUser(User user);
}
