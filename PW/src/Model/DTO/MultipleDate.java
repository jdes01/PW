package Model.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase MultipleDate
 * @author Marcos Rodriguez Moreno
 *
 */
public class MultipleDate implements DateInterface, Serializable {

    private ArrayList<Date> dateList = new ArrayList<Date>();

/**
 * Constructor de MultipleDate
 * @param newDate Nueva fecha
 */
    
    public MultipleDate(Date newDate) {
        this.dateList.add(newDate);
    }

/**
 * Getter de fechas
 * @return Retorna la lista de las fechas
 */
    
    public ArrayList<Date> getDates(){ return this.dateList; }

/**
 * Funcion publica para añadir fechas
 * @param newDate Nueva fecha
 */
    
    public void addDate(Date newDate){ this.dateList.add(newDate); }
    
}