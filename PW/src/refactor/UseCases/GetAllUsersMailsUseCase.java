package refactor.UseCases;

import java.util.ArrayList;

import refactor.Repository.UserRepository;

public class GetAllUsersMailsUseCase {
    
    public static ArrayList<String> getAllUsersMails(){

        UserRepository userRepository = new UserRepository();

        return userRepository.getAllUsersMails();
    }
}
