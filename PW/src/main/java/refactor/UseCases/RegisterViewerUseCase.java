package refactor.UseCases;

import java.io.IOException;
import java.sql.SQLException;

import refactor.Repository.UserRepository;

/**
 * Clase encargada del caso de uso que trata de especificarle a los repositorios los datos de los visitantes del sistema.
 * 
 * @author Javier De Santiago Palomino
 */
public class RegisterViewerUseCase { 

    /** 
     * Función encargada del caso de uso que trata de especificarle a los repositorios los datos de los visitantes del sistema.
     * 
     * @param name Nombre del visitante del sistema.
     * @param lastName Apellido del visitante del sistema.
     * @param nickName Apodo del visitante del sistema.
     * @param mail Correo del visitante del sistema.
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:

        The forName method in class Class.
        The findSystemClass method in class ClassLoader .
        The loadClass method in class ClassLoader. 

        but no definition for the class with the specified name could be found. 
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public static void registerViewer(String name, String lastName, String nickName, String mail, String password) throws IOException, ClassNotFoundException, SQLException{

        UserRepository userRepository = new UserRepository();
        
        if( userRepository.anyUserWithMail(mail) == true ){

            return;
        
        } else {
            
            userRepository.saveViewer(name, lastName, nickName, mail, password);
        }
    }
    
}
