package refactor.UseCases;

import java.io.IOException;

import refactor.Model.Entities.User;
import refactor.Repository.UserRepository;

/**
 * Clase que se encarga de gestionar el caso de uso para llamar al repositorio para dar acceso al sistema a un usuario.
 * 
 * @author Alberto Cano Turnos
 */
public class LoginUserUseCase {
    
    /** 
     * Función que se encarga del caso de uso encargado de averiguar si un usuario está registrado en el sistema.
     * 
     * @param mail Representa el identificador del usuario al que se le tiene que dar acceso
     * @return Boolean Se devuelve True si se ha encontrado al usuario en el sistema.
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    public static Boolean loginUser(String mail, String password) throws IOException{

        UserRepository userRepository = new UserRepository();

        if( userRepository.anyUserWithMail(mail) == true ){

        	User user = userRepository.getUserByMail(mail);
        	if(user.getPassword().contentEquals(password)) {
        		userRepository.updateLastLoginDateByMail(mail);
                return true;

        	}
        }
        return false;
    }    
}
