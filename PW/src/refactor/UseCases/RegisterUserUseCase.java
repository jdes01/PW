package refactor.UseCases;

import java.io.IOException;

import refactor.Model.Entities.User;
import refactor.Repository.UserRepository;

public class RegisterUserUseCase { 

    public static void registerUser(String name, String lastName, String nickName, String mail) throws IOException{

        UserRepository userRepository = new UserRepository();

        User user = new User(name, lastName, nickName, mail);
        
        userRepository.saveUser(user);
    }
    
}
