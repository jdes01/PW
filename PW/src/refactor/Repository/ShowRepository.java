package refactor.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;

import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.ShowSesion;

public class ShowRepository {

    private String path = System.getProperty("user.dir") + File.separator + "src/refactor/Repository/shows.txt";
    
    public ShowRepository(){}

    public void saveShow(Show show) throws IOException {

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(path), ("Show").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), show.getUuid().toString().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), show.getTitle().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), show.getDescription().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), show.getCategory().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), String.valueOf(show.getCapacity()).getBytes(), StandardOpenOption.APPEND);

        Files.write(Paths.get(path), (" Sesions:").getBytes(), StandardOpenOption.APPEND);

        for(ShowSesion showSesion: show.getSesions()){

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format1.format(showSesion.getDate().getTime());
            
            Files.write(Paths.get(path), (" [").getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(path), formatted.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(path), String.valueOf(showSesion.getTickets()).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(path), (" ]").getBytes(), StandardOpenOption.APPEND);
        }

        Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);
    }
}
