package Model.Entities.Show;

import java.io.Serializable;

import Model.DTO.SingleDate;

/**
 * Clase PunctualShow
 * @author Marcos Rodriguez Moreno
 *
 */
public class PunctualShow extends Show implements Serializable {
	 /*
     * Constructor de PunctualShow
     * @param title Titulo
     * @param cathegory Categoria
     * @param description Descripcion
     * @param capacity Capacidad
     * @param singleDate Fecha
     * @param firstLocation Localizacion
     */

	private static final long serialVersionUID = 1L;
	private SingleDate singleDate;

	public PunctualShow(String title, String cathegory, String description, Integer capacity, SingleDate singleDate, String firstLocation){

        super(title, cathegory, description, capacity);

        addLocation(firstLocation);

        this.singleDate = singleDate;
    }

/**
 * Getter de la fecha
 * @return Retorna la fecha
 */
    
    public SingleDate getDate(){ return singleDate; }
}