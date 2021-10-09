import Show;
import PeriodicDate;

public class SeasonShow extends Show {

    private PeriodicDate periodicDate;

    public PunctualShow(String title, String cathegory, String description, Int capacity, PeriodicDate periodicDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.periodicDate = periodicDate;
    }    

}
