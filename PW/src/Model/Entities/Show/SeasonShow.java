package Model.Entities.Show;

import java.io.Serializable;

import Model.DTO.PeriodicDate;

public class SeasonShow extends Show implements Serializable {

    private PeriodicDate periodicDate;

    public SeasonShow(String title, String cathegory, String description, Integer capacity, PeriodicDate periodicDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.periodicDate = periodicDate;
    }    

    public PeriodicDate getDate(){ return this.periodicDate; }

}
