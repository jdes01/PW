package Model.DTO;

import java.io.Serializable;

public class LocationAndAvailableTickets implements Serializable {
    
    private String location;
    private Integer tickets;

    public LocationAndAvailableTickets(String location, Integer tickets){

        this.location = location;
        this.tickets = tickets;
    }

    String getLocation(){ return this.location; }
    Integer getTickets(){ return this.tickets; }

    void setLocation(String location){ this.location = location; }
    void setTickets(Integer tickets){ this.tickets = tickets; }
}
