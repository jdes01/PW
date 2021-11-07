package refactor.UseCases;

import java.io.IOException;

import refactor.Repository.UserRepository;


public class LoginUserUseCase {

    public static Boolean loginUser(String mail) throws IOException{

        UserRepository userRepository = new UserRepository();

        return userRepository.anyUserWithMail(mail);
    }    
}
