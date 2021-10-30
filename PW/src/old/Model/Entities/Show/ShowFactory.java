package old.Model.Entities.Show;

import java.io.Serializable;

import old.Model.DTO.MultipleDate;
import old.Model.DTO.PeriodicDate;
import old.Model.DTO.SingleDate;
import old.Model.Entities.Show.PunctualShow;

/**
 * Clase que usa el patron de diseño factory
 * @author Javier De Santiago
 *
 */
public class ShowFactory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param cathegory Categoria
     * @param description Descripcion
     * @param locationCapacity Capacidad
     * @param singleDate Fecha
     * @param firstLocation Localizacion
     * @return punctualShow
     */	
	
    static public PunctualShow createShow(String title, String cathegory, String description, Integer locationCapacity, SingleDate singleDate, String firstLocation){
            
        PunctualShow punctualShow = new PunctualShow(title, cathegory, description, locationCapacity, singleDate, firstLocation); 
        
        return punctualShow;
    }

	/**
     * Funcion para crear shows
     * @param title Titulo
     * @param cathegory Categoria
     * @param description Descripcion
     * @param locationCapacity Capacidad
     * @param periodicDate Fecha
     * @param firstLocation Localizacion
     * @return seasonShow
     */	
    
    static public SeasonShow createShow(String title, String cathegory, String description, Integer locationCapacity, PeriodicDate periodicDate, String firstLocation){

        SeasonShow seasonShow = new SeasonShow(title, cathegory, description, locationCapacity, periodicDate, firstLocation); 
    
        return seasonShow;
    }

	/**
     * Funcion para crear shows
     * @param title Titulo
     * @param cathegory Categoria
     * @param description Descripcion
     * @param locationCapacity Capacidad
     * @param multipleDate Fecha
     * @param firstLocation Localizacion
     * @return multiplePassShow
     */	
    
    static public MultiplePassShow createShow(String title, String cathegory, String description, Integer locationCapacity, MultipleDate multipleDate, String firstLocation){

        MultiplePassShow multiplePassShow = new MultiplePassShow(title, cathegory, description, locationCapacity, multipleDate, firstLocation);
    
        return multiplePassShow;
    }
}
