package refactor.UseCases;

import java.io.IOException;

import refactor.Repository.UserRepository;


public class GetUserDataUseCase {

    public static void GetUserData(String name, String lastName, String nickName, String mail) throws IOException{

        UserRepository userRepository = new UserRepository();

        userRepository.getName();
        userRepository.getLastName();
        userRepository.getNickName();
        userRepository.getMail();   
    } 
}
