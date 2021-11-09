package refactor.UseCases;

import refactor.Repository.UserRepository;

/**
 * Clase que se encarga del caso de uso que llama al repositorio para actualizar los datos de un usuario.
 * 
 * @author David Salcedo Sánchez
 */
public class UpdateUserDataUseCase {
    
    
    /**
     * Función que se encarga del caso de uso que llama al repositorio para actualizar los datos de un usuario.
     *  
     * @param userMail Correo del usuario del que se quiere actualizar la información.
     * @param newName Nombre nuevo del usuario.
     * @param newLastName Apellido nuevo del usuario.
     * @param newNickName Apodo nuevo del usuario.
     * @param newMail Correo nuevo del usuario.
     */
    public static void updateUserData(String userMail, String newName, String newLastName, String newNickName, String newMail){

        UserRepository userRepository = new UserRepository();

        userRepository.updateUserName(     userRepository.getUserByMail(userMail).getUuid(), newName);
        userRepository.updateUserLastName( userRepository.getUserByMail(userMail).getUuid(), newLastName);
        userRepository.updateUserNickName( userRepository.getUserByMail(userMail).getUuid(), newNickName);
        userRepository.updateUserMail(     userRepository.getUserByMail(userMail).getUuid(), newMail);
    }
}
