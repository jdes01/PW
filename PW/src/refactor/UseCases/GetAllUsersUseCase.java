package refactor.UseCases;

import java.util.ArrayList;

import refactor.Model.Entities.User;
import refactor.Repository.UserRepository;

public class GetAllUsersUseCase {
    
    public static ArrayList<User> getAllUsers(){

        UserRepository userRepository = new UserRepository();

        return userRepository.getAllUsers();
    }
}
