package Model.Entities.Show;

import Model.DTO.PeriodicDate;

/**
 * Clase SeasonShow
 * @author Javier De Santiago Palomino
 *
 */

public class SeasonShow extends Show {

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
