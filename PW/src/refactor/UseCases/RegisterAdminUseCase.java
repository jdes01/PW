package refactor.UseCases;

import java.io.IOException;
import java.sql.SQLException;

import refactor.Repository.UserRepository;

/**
 * Caso de uso que se encarga de llamar al repositorio para registrar un usuario.
 * 
 * @author Marcos Rodríguez Moreno
 */
public class RegisterAdminUseCase { 

    /** 
     * Función dedicada al caso de uso que se encarga de llamar al repositorio para registrar un usuario.
     * 
     * @param name Nombre del usuario a registrar.
     * @param lastName Apellido del usuario a registrar.
     * @param nickName Apodo del usuario a registrar.
     * @param mail Correo del usuario a registrar.
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:

        The forName method in class Class.
        The findSystemClass method in class ClassLoader .
        The loadClass method in class ClassLoader. 

        but no definition for the class with the specified name could be found. 
     * @throws SQLException An exception that provides information on a database access error or other errors.

     */
    public static void registerAdmin(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException{

        UserRepository userRepository = new UserRepository();
        
        if( userRepository.anyUserWithMail(mail) == true ){

            return;
        
        } else {
            
            userRepository.saveAdmin(name, lastName, nickName, mail);
        }
    }
    
}
