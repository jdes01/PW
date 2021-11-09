package refactor.UseCases;

import java.io.IOException;

import refactor.Repository.UserRepository;

/**
 * Clase que se encarga de gestionar el caso de uso para llamar al repositorio y borrar un usuario concreto.
 * 
 * @author David Salcedo Sánchez 
 */
public class DeleteUserUseCase {

    
    /** 
     * Caso de uso que se encarga de decirle a los repositorios de borrar un usuario especificado como parámetro.
     * 
     * @param mail el mail del usuario que servirá para especificar cuál es el usuario que se quiere eliminar.
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    public static void deleteUser(String mail) throws IOException{

        UserRepository userRepository = new UserRepository();
        
        if (userRepository.anyUserWithMail(mail) == true){

            userRepository.deleteUserByMail(mail);

        } else {

            return;
        }

    }
    
}
