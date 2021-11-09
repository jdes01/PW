package refactor.Model.Entities.Show;

import java.util.Calendar;

/**
 * Clase que se encargará de crear un show que acontecerá en una fecha en específico
 * 
 * @author Javier De Santiago Palomino
 */
public class PunctualShow extends Show{
    
    /**
     * Constructor que se encarga de crear un show que acontecerá en una fecha en específico
     * 
     * @param title Título del show
     * @param description Descripción del show
     * @param category Categoría del show
     * @param capacity Aforo del show
     * @param date Fecha en la que acontecerá el show
     */
    public PunctualShow(String title, String description, String category, Integer capacity, Calendar date){

        super(title, description, category, capacity);

        super.addSesion(date, capacity);
    }
    
}
