package refactor.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import refactor.Model.Entities.User;

public class UserRepository {

    private String filename = System.getProperty("user.dir") + File.separator + "src/refactor/Repository/users.txt";

    public UserRepository(){}

    public void saveUser(User user) throws IOException {

        Files.write(Paths.get(filename), ("User").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), user.getUuid().toString().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), user.getName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), user.getLastName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), user.getNickName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(filename), user.getMail().getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(filename), "\n".getBytes(), StandardOpenOption.APPEND);
    }    
}
