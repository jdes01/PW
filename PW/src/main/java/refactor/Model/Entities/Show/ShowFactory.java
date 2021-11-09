package refactor.Model.Entities.Show;

import java.util.Calendar;
import java.util.List;

/**
 * Clase encargada de llamar a un constructor u otro en función del tipo de show que se está creando.
 * 
 * @author David Salcedo Sánchez
 */
public class ShowFactory {
    
    /** 
     * Función encargada de llamar al constructor de la clase que crea un show que se celebrará un día en específico.
     * 
     * @param title Título del show
     * @param description Descripción del show
     * @param category Parámetro en función del cual se creará un tipo de show o de otro
     * @param capacity Aforo del show
     * @param date Fecha en la que acontecerá el show
     * @return Show Tipo de show creado con la información añadida en los parámetros
     */
    public static Show createShow(String title, String description, String category, Integer capacity, Calendar date){
        PunctualShow punctualShow = new PunctualShow(title, description, category, capacity, date);
        return punctualShow;
    }
    
    /** 
     * Función encargada de llamar al constructor de la clase que crea un show que se celebrará durante unas semanas seguidas y todas las semanas en el mismo día.
     * 
     * @param title Título del show
     * @param description Descripción del show
     * @param category Parámetro en función del cual se creará un tipo de show o de otro
     * @param capacity Aforo del show
     * @param beginDate Primera semana en la que acontecerá el show
     * @param endDate Última semana en la que acontecerá el show
     * @param weekDay Día de la semana en el que siempre acontecerá el show
     * @return Show Tipo de show creado con la información añadida en los parámetros
     */
    public static Show createShow(String title, String description, String category, Integer capacity, Calendar beginDate, Calendar endDate, int weekDay){
        SeasonShow seasonShow = new SeasonShow(title, description, category, capacity, beginDate, endDate, weekDay);
        return seasonShow;
    }
    
    /** 
     * Función encargada de llamar al constructor de la clase que crea un show que se celebrará una serie de fechas concretas.
     * 
     * @param title Título del show
     * @param description Descripción del show
     * @param category Parámetro en función del cual se creará un tipo de show o de otro
     * @param capacity Aforo del show
     * @param dates Lista de fechas en las que acontecerá el show
     * @return Show Tipo de show creado con la información añadida en los parámetros
     */
    public static Show createShow(String title, String description, String category, Integer capacity, List<Calendar> dates){
        MultiplePassShow multiplePassShow = new MultiplePassShow(title, description, category, capacity, dates);
        return multiplePassShow;
    }
    
}
