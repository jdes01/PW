import Show;
import MultipleDate;

public class MultiplePassShow extends Show {

    private MultipleDate multipleDate;

    public PunctualShow(String title, String cathegory, String description, Int capacity, MultipleDate multipleDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.multipleDate = multipleDate;
    }   

    public MultipleDate getDate(){ return this.multipleDate; }

}
