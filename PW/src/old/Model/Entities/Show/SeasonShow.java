package old.Model.Entities.Show;

import java.io.Serializable;

import old.Model.DTO.PeriodicDate;

/**
 * Clase SeasonShow
 * @author Javier De Santiago Palomino
 *
 */
public class SeasonShow extends Show implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PeriodicDate periodicDate;

	/**
     * Constructor de SeasonShow
     * @param title Titulo
     * @param cathegory Categoria
     * @param description Descripcion
     * @param capacity Capacidad
     * @param periodicDate Fecha
     * @param firstLocation Localizacion
     */
    
    public SeasonShow(String title, String cathegory, String description, Integer capacity, PeriodicDate periodicDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.periodicDate = periodicDate;
    }    
    
    /**
     * Getter de la fecha
     * @return Retorna la fecha
     */
    
    public PeriodicDate getDate(){ return this.periodicDate; }

}
