package refactor.UseCases;

import refactor.Repository.UserRepository;


public class UpdateUserDataUseCase {
    
    public static void updateUserData(String userMail, String newName, String newLastName, String newNickName, String newMail){

        UserRepository userRepository = new UserRepository();

        userRepository.updateUserName(     userRepository.getUserByMail(userMail).getUuid(), newName);
        userRepository.updateUserLastName( userRepository.getUserByMail(userMail).getUuid(), newLastName);
        userRepository.updateUserNickName( userRepository.getUserByMail(userMail).getUuid(), newNickName);
        userRepository.updateUserMail(     userRepository.getUserByMail(userMail).getUuid(), newMail);
    }
}
