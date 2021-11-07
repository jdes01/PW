package refactor.UseCases;

import java.io.IOException;

import refactor.Repository.UserRepository;


public class LoginUserUseCase {

    public static void loginUser(String mail) throws IOException{

        UserRepository userRepository = new UserRepository();

        // Este no tengo ni zorra de como plantearlo 
        // userRepository.userIsLogged(user.getMail());
    }
    
}
