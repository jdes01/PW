package Model.Entities.Show;

import java.io.Serializable;
import java.util.ArrayList;

import Model.DTO.LocationAndAvailableTickets;
import Model.Entities.Review.Review;

/**
 * Clase de los shows
 * @author Alberto Cano Turnes
 *
 */
public class Show implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String description;

    private Integer capacity;

    private ArrayList<LocationAndAvailableTickets> locationsAndAvailableTickets = new ArrayList<LocationAndAvailableTickets>();

    private ArrayList<Review> showReviews = new ArrayList<Review>();

	private String title;

	private String cathegory;

    /**
     * Constructor de Show
     * @param title Titulo
     * @param cathegory Categoria
     * @param description Descripcion
     * @param capacity Capacidad
     */
    
    public Show(String title, String cathegory, String description, Integer capacity){

        this.title        = title;
        this.cathegory    = cathegory;
        this.description  = description;
        this.capacity     = capacity;
    }  
    
/**
 * Getter de titulo
 * @return Retorna el titulo
 */
    public String getTitle(){ return this.title; }

    /**
     * Getter de la categoria
     * @return Retorna la categorria
     */    
    
	public String getCathegory(){ return this.cathegory; }
	
	/**
	 * Getter de la descripcion
	 * @return Retorna la descripcion
	 */
	
	public String getDescription(){ return this.description; }

	/**
	 * Getter de la capacidad
	 * @return Retorna la capacidad
	 */	

    public Integer getCapacity(){ return this.capacity; }

    /**
     * Getter de la lozalizacion donde los tickets estan disponible
     * @return Retorna las localizaciones
     */
    
    public ArrayList<LocationAndAvailableTickets> getLocationAndAvailableTickets(){ return locationsAndAvailableTickets; }
	
/**
 * Setter del titulo
 * @param title Titulo del show
 */
	
	public void setTitle(String title){ this.title = title; }
	
	/**
	 * Setter de la categoria
	 * @param cathegory Categoria del show
	 */
	
	public void setCathegory(String cathegory){ this.cathegory = cathegory; }

	/**
	 * Setter de la descripccion
	 * @param description Descripcion del show
	 */	
	
	public void setDescription(String description){ this.description = description; }

	/**
	 * Setter de la capacidad
	 * @param capacity Capacidad del show
	 */
	
    public void setCapacity(Integer capacity){ this.capacity = capacity; }

    /**
     * Funcion publica para añadir la localizacion
     * @param location Localizacion del show
     */
    
    public void addLocation(String location){

        LocationAndAvailableTickets locationAndAbailableTickets = new LocationAndAvailableTickets(location, this.capacity);

        this.locationsAndAvailableTickets.add(locationAndAbailableTickets);
    }

    /**
     * Funcion publica para añadir la review de un show
     * @param review Review del show
     */
    
    public void addShowReview(Review review){

        this.showReviews.add(review);
    }
      
}
