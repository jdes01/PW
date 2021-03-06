package refactor.Model.Entities.Show;

import java.util.Calendar;

/**
 * Clase que se encarga de crear un tipo de show que se acontecerá siempre el mismo día durante todas las semanas de un periodo establecido.
 * 
 * @author Marcos Rodríguez Moreno
 */
public class SeasonShow extends Show{

    /**
     * Constructor que crea un tipo de show que se acontecerá siempre el mismo día durante todas las semanas de un periodo establecido.
     * 
     * @param title Título del show
     * @param description Descripción del show
     * @param category Categoría del show
     * @param capacity Aforo del show
     * @param beginDate Primera fecha en la que acontecerá el show
     * @param endDate Última fecha en la que acontecerá el show
     * @param weekDay Día de la semana en la que acontecerán los shows
     */
    public SeasonShow(String title, String description, String category, Integer capacity, Calendar beginDate, Calendar endDate, int weekDay){

        super(title, description, category, capacity);
        
        if(beginDate.getTimeInMillis() != endDate.getTimeInMillis()){

            super.addSesion(beginDate, capacity);

            //TODO: add all weekdays between begin date and end date

            super.addSesion(endDate, capacity);
            
        } else { super.addSesion(beginDate, capacity); }

    }
    
}
