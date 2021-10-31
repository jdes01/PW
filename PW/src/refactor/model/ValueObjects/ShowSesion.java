package refactor.model.ValueObjects;

import java.util.Calendar;

public class ShowSesion {

    private Calendar _date;
    private int  _tickets;

    public ShowSesion(Calendar date, int tickets){

        this._date = date;
        this._tickets = tickets;
    }

    public Calendar getDate(){ return this._date; }
    public int getTickets(){ return this._tickets; }

    public void setDate(Calendar date){ this._date = date; }
    public void setTickets(int tickets){ this._tickets = tickets; }
    
}
