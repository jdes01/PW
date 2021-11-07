package refactor.UseCases;

import java.io.IOException;
import java.sql.SQLException;

import refactor.Repository.UserRepository;

public class RegisterAdminUseCase { 

    public static void registerAdmin(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException{

        UserRepository userRepository = new UserRepository();
        
        if( userRepository.anyUserWithMail(mail) == true ){

            return;
        
        } else {
            
            userRepository.saveAdmin(name, lastName, nickName, mail);
        }
    }
    
}
