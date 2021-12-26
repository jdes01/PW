package refactor.Model.Entities.Show;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import refactor.Model.ValueObjects.ShowSesion;

/**
 * Clase que se encargará de proveer las funciones necesarias para la gestión de la información del show.
 * 
 * @author Alberto Cano Turnes
 */
public class Show {

    private UUID _id;

    private String _title;
    private String _description;
    private String _category;
    private int    _capacity;

    private List<ShowSesion> _sesions = new ArrayList<ShowSesion>();

    public Show() {}

    /**
     * Constructor de la clase show
     * 
     * @param title Título del show
     * @param description Descripción del show
     * @param category Parámetro en función del cuál se creará un tipo de show u otro
     * @param capacity Aforo del show
     */
    public Show(String title, String description, String category, int capacity){

        UUID uuid = UUID.randomUUID();
        this._id = uuid;

        this._title = title;
        this._description = description;
        this._category = category;
        this._capacity = capacity;
    }
    
    /** 
     * Función que devuelve el id del show
     *
     * @return UUID id del show
     */
    public UUID getUuid(){ return this._id; }

    
    /** 
     * Función que devuelve el título del show
     * 
     * @return String Título del show
     */
    public String getTitle(){ return this._title; }

    
    /** 
     * Función que devuelve la descripción del show
     * 
     * @return String Descripción del show
     */
    public String getDescription(){ return this._description; }

    
    /** 
     * Función que devuelve la categoría del show
     * 
     * @return String Categoría del show
     */
    public String getCategory(){ return this._category; }

    
    /** 
     * Función que devuelve el aforo del show
     * 
     * @return int Aforo del show
     */
    public int getCapacity(){ return this._capacity; }

    
    /** 
     * Función que devuelve la lista de fechas del show
     * 
     * @return List<ShowSesion> Lista de fechas dle show
     */
    public List<ShowSesion> getSesions(){ return this._sesions; }
    
    /** 
     * Función que actualiza el id del show por el del parámetro que recibe.
     * 
     * @param id Nuevo id del show
     */
    public void setID(String id) { this._id = UUID.fromString(id); }

    /** 
     * Función que actualiza el título del show por el del parámetro que recibe.
     * 
     * @param title Nuevo título del show
     */
    public void setTitle(String title){ this._title = title; }

    /** 
     * Función que actualiza la descripción del show por el del parámetro que recibe.
     * 
     * @param description Nueva descripción del show
     */
    public void setDescription(String description){ this._description = description; }

    
    /** 
     * Función que actualiza la categoría del show por la del parámetro que recibe.
     * 
     * @param category Nueva categoría del show
     */
    public void setCategory(String category){ this._category = category; }

    /** 
     * Función que actualiza el aforo del show por el del parámetro que recibe.
     * 
     * @param capacity Nuevo aforo del show
     */
    public void setCapacity(int capacity){ this._capacity = capacity; }
    
    /** 
     * Función que añade una nueva sesión a un show especificando también su aforo.
     * 
     * @param date Nueva fecha del show
     * @param tickets Aforo de esa fecha
     */
    public void addSesion(int id, Calendar date, int tickets){

        ShowSesion showSesion = new ShowSesion(id, date, tickets);

        this._sesions.add(showSesion);
    }
    
    public void addSesion(Calendar date, int tickets){

        ShowSesion showSesion = new ShowSesion(date, tickets);

        this._sesions.add(showSesion);
    }

    
}
