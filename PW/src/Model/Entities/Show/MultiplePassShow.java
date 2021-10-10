package Model.Entities.Show;

import java.io.Serializable;

import Model.DTO.MultipleDate;

public class MultiplePassShow extends Show implements Serializable {

    private MultipleDate multipleDate;

    public MultiplePassShow(String title, String cathegory, String description, Integer capacity, MultipleDate multipleDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.multipleDate = multipleDate;
    }   

    public MultipleDate getDate(){ return this.multipleDate; }

}
