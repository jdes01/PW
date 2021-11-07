package refactor.UseCases;

import java.io.IOException;

import refactor.Repository.UserRepository;


public class DeleteUserUseCase {

    public static void deleteUser(String mail) throws IOException{

        UserRepository userRepository = new UserRepository();
        
        if (userRepository.anyUserWithMail(mail) == true){

            userRepository.deleteUserByMail(mail);

        } else {

            return;
        }

    }
    
}
