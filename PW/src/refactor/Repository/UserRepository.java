package refactor.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import refactor.Model.Entities.User;

public class UserRepository {

    private String path = System.getProperty("user.dir") + File.separator + "src/refactor/Repository/users.txt";

    public UserRepository(){}

    public void saveUser(User user) throws IOException {

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(path), ("User").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getUuid().toString().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getLastName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getNickName().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), user.getMail().getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);
    }    
}
