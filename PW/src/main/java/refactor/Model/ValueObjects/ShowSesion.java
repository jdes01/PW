package refactor.Model.ValueObjects;

import java.util.Calendar;

/**
 * Clase show session
 * 
 * @author Javier De Santiago Palomino
 */

public class ShowSesion {

	private int _id;
    private Calendar _date;
    private int  _tickets;

    /**
     * Constructor de ShowSession
     * 
     * @param date Fecha del show
     * @param tickets tickets del show
     */

    public ShowSesion(int id, Calendar date, int tickets){

    	this._id = id;
        this._date = date;
        this._tickets = tickets;
    }
    
   public ShowSesion(Calendar date, int tickets) {
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
    
    public int getId() { return this._id; }

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
    
    
    public void setId(int id) { this._id = id; }
}
