package Model.DTO;

import java.util.Date;

/**
 * Clase SingleDate
 * @author Javier De Santiago Palomino
 *
 */

public class SingleDate implements DateInterface {

    private Date date;

    /**
     * Constructor de SingleDate
     * @param newDate Nueva fecha
     */
    
    public SingleDate(Date newDate) {
        this.date = newDate;
    }

    /**
     * Getter de date
     * @return Retorna la fecha
     */
    
    public Date getDate(){ return this.date; }

    /**
     * Setter de la fecha
     * @param newDate Nueva fecha
     */
    
    public void setDate(Date newDate){ this.date = newDate; }
    
}
