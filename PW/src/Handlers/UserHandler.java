package Model;

import Model.User;

public class UserHandler {
    
    void createUser(String name);

    void deleteUser(User user);

    User getUser(Integer id);

    void updateUser(User user);
}
