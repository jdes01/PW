package refactor.Model.Entities.Show;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import refactor.Model.ValueObjects.ShowSesion;

public class Show {

    private UUID _id;

    private String _title;
    private String _description;
    private String _category;
    private int    _capacity;

    private List<ShowSesion> _sesions = new ArrayList<ShowSesion>();


    
    public Show() {}

    public Show(String title, String description, String category, int capacity){

        UUID uuid = UUID.randomUUID();
        this._id = uuid;

        this._title = title;
        this._description = description;
        this._category = category;
        this._capacity = capacity;
    }



    public UUID getUuid(){ return this._id; }

    public String getTitle(){ return this._title; }

    public String getDescription(){ return this._description; }

    public String getCategory(){ return this._category; }

    public int getCapacity(){ return this._capacity; }

    public List<ShowSesion> getSesions(){ return this._sesions; }


    public void setID(String id) { this._id = UUID.fromString(id); }

    public void setTitle(String title){ this._title = title; }

    public void setDescription(String description){ this._description = description; }

    public void setCategory(String category){ this._category = category; }

    public void setCapacity(int capacity){ this._capacity = capacity; }



    public void addSesion(Calendar date, int tickets){

        ShowSesion showSesion = new ShowSesion(date, tickets);

        this._sesions.add(showSesion);
    }
    
}
