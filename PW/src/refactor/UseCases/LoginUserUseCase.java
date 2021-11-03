package refactor.UseCases;

import java.io.IOException;

import refactor.Model.Entities.User;
import refactor.Repository.UserRepository;


public class LoginUserUseCase {

    public static void loginUser(String mail) throws IOException{

        UserRepository userRepository = new UserRepository();

        User user = user(mail);

        userRepository.userIsLogged(user.getMail());
    }
    
}
