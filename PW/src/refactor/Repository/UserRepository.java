package refactor.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import refactor.DAOs.UserDAO;
import refactor.Model.Entities.User;

public class UserRepository {

    public UserRepository(){}

    public void saveUser(User user) throws IOException, ClassNotFoundException, SQLException {

        UserDAO userDAO = new UserDAO();

        userDAO.create(user);

    }    
}
