package Model.Entities.Show;

import Model.DTO.SingleDate;

public class PunctualShow extends Show {

    private SingleDate singleDate;

    public PunctualShow(String title, String cathegory, String description, Integer capacity, SingleDate singleDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.singleDate = singleDate;
    }

    public SingleDate getDate(){ return this.singleDate; }
}