package Model.DTO;

import java.io.Serializable;

/**
 * Clase para la localizacion y los tickets disponibles
 * @author Javer De Santiago Palomino
 *
 */
public class LocationAndAvailableTickets implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String location;
    private Integer tickets;

/**
 * Constructor de LocationAndAvailableTickets
 * @param location Localizacion
 * @param tickets Tickets
 */
    
    public LocationAndAvailableTickets(String location, Integer tickets){

        this.location = location;
        this.tickets = tickets;
    }

/**
 * Getter de location
 * @return Retorna la localizacion
 */
    
    String getLocation(){ return this.location; }
    
/**
 * Getter de tickets
 * @return Retorna los tickets
 */
    
    Integer getTickets(){ return this.tickets; }

/**
 * Setter de la localizacion
 * @param location Localizacion
 */
    
    void setLocation(String location){ this.location = location; }
    
/**
 * Setter de tickets
 * @param tickets Tickets
 */
    
    void setTickets(Integer tickets){ this.tickets = tickets; }
}
