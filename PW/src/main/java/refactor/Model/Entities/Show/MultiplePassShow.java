package refactor.Model.Entities.Show;

import java.util.Calendar;
import java.util.List;

/**
 * Clase que se encargará de crear un tipo de show que acontecerá durante una serie de fechas en específico.
 * 
 * @author David Salcedo Sánchez
 */
public class MultiplePassShow extends Show{

    /**
     * Función que se encarga de crear un tipo de show que acontecerá durante una serie de fechas en específico.
     * 
     * @param title Título del show
     * @param description Descripción del show
     * @param category Categoría del show
     * @param capacity Aforo del show
     * @param dates Lista de fechas en las que acontecerá el show
     */
    public MultiplePassShow(String title, String description, String category, Integer capacity, List<Calendar> dates){

        super(title, description, category, capacity);

        for(Calendar date: dates){
            super.addSesion(date, capacity);
        }
    }
    
}
