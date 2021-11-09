package refactor.Model.ValueObjects;

import java.util.Calendar;

/**
 * Clase show session
 * 
 * @author Javier De Santiago Palomino
 */

public class ShowSesion {

    private Calendar _date;
    private int  _tickets;

    /**
     * Constructor de ShowSession
     * 
     * @param date Fecha del show
     * @param tickets tickets del show
     */

    public ShowSesion(Calendar date, int tickets){

        this._date = date;
        this._tickets = tickets;
    }

/**
 * Getter de la fecha
 * 
 * @return Calendar
 */

    public Calendar getDate(){ return this._date; }

/**
 * Getter de los tickets
 * 
 * @return Integer
 */

    public int getTickets(){ return this._tickets; }

/**
 * Setter de la fecha
 * @param date Fecha del show
 */

    public void setDate(Calendar date){ this._date = date; }

/**
 * Setter de los tickets
 * 
 * @param tickets Tickets del show
 */

    public void setTickets(int tickets){ this._tickets = tickets; }
    
}
