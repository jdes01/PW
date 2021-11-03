package refactor.UseCases;

import java.io.IOException;

import refactor.Model.Entities.User;
import refactor.Repository.UserRepository;


public class DeleteUserUseCase {

    public static void deleteUser(String name) throws IOException{

        UserRepository userRepository = new UserRepository();

        User user = userRepository.getUserByName(name);
        
        userRepository.deleteUserByID(user.getUuid());
    }
    
}
