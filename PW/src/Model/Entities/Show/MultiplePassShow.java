package Model.Entities.Show;

import java.io.Serializable;

import Model.DTO.MultipleDate;

/**
 * Clase MultiplePassShow
 * @author David Salcedo Sanchez
 *
 */
public class MultiplePassShow extends Show implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MultipleDate multipleDate;
    
/**
 * Constructor de MultiplePassShow
 * @param title Titulo
 * @param cathegory Categoria
 * @param description Descripcion
 * @param capacity Capacidad
 * @param multipleDate Fecha
 * @param firstLocation Localizacion
 */

    public MultiplePassShow(String title, String cathegory, String description, Integer capacity, MultipleDate multipleDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.multipleDate = multipleDate;
    }   

    public MultipleDate getDate(){ return this.multipleDate; }

}
