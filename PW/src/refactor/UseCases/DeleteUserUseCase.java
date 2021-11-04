package refactor.UseCases;

import java.io.IOException;

import refactor.Repository.UserRepository;


public class DeleteUserUseCase {

    public static void deleteUser(String mail) throws IOException{

        UserRepository userRepository = new UserRepository();
        
        // TODO: userRepository.deleteUserByMail(mail);
    }
    
}
