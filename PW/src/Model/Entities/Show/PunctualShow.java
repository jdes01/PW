import Show;
import SingleDate;

public class PunctualShow extends Show {

    private SingleDate singleDate;

    public PunctualShow(String title, String cathegory, String description, Int capacity, SingleDate singleDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.singleDate = singleDate;
    }
}