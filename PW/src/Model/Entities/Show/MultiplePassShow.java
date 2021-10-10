package Model.Entities.Show;

import Model.DTO.MultipleDate;

public class MultiplePassShow extends Show {

    private MultipleDate multipleDate;

    public MultiplePassShow(String title, String cathegory, String description, Integer capacity, MultipleDate multipleDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.multipleDate = multipleDate;
    }   

    public MultipleDate getDate(){ return this.multipleDate; }

}
