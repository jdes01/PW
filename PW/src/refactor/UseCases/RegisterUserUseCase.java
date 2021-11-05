package refactor.UseCases;

import java.io.IOException;
import java.sql.SQLException;

import refactor.Repository.UserRepository;

public class RegisterUserUseCase { 

    public static void registerUser(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException{

        UserRepository userRepository = new UserRepository();
        
        if( userRepository.anyUserWithMail(mail) == true ){

            return;
        
        } else {
            
            userRepository.saveUser(name, lastName, nickName, mail);
        }
    }
    
}
