package Model.Repository;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.Entities.Show.Show;

/**
 * Clase repositorio de los shows
 * @author Alberto Cano Turnes
 *
 */

public class ShowRepository {
 
/**
 * Funcion publica para guardar shows
 * @param show Show que se va a guardar
 */

    public void saveShow(Show show){

        try {
        	FileOutputStream file = new FileOutputStream(new File("shows.txt"));
        	ObjectOutputStream output = new ObjectOutputStream(file);
        	
        	output.writeObject(show);
        	
        	output.close();
        	file.close();
        } catch (FileNotFoundException error) {
        	error.printStackTrace();
        } catch (IOException error) {
        	error.printStackTrace();
        }
    }

/**
 * Getter de shows
 * @throws IOException Signals that an I/O of some sort has occured
 * @throws FileNotFoundException Signals that an attempt to open the file denoted by a specified pathname has failed
 */
    
    @SuppressWarnings("null")
	public ArrayList<Show> getShows(){
    	ArrayList<Show> shows = null;
    	
    	try {
	    	FileInputStream file = new FileInputStream(new File("shows.txt"));
	    	ObjectInputStream input = new ObjectInputStream(file);
	    	
	    	while(true) {
	    		try {
	    			shows.add((Show) input.readObject());
	    		} catch (EOFException error) {
	    			input.close();
	    			file.close();
	    			return shows;
	    		} catch (ClassNotFoundException error) {
	    			input.close();
	    			file.close();
	    			error.printStackTrace();
	    		}
	    	}
    	} catch (FileNotFoundException error) {
        	error.printStackTrace();
        } catch (IOException error) {
        	error.printStackTrace();
        }
    	
    	return shows;
    }
/**
 * Funcion publica para cancelar un show
 */
    public void cancelShow(Show show) {};

/**
 * Funcion publica para cancelar todos los show
 */
    
    public void cancelAllShows() {};

/**
 * Funcion publica para obtener los shows por su titulo
 * @param title Titulo del show
 */
    
    public Show getShowByTitle(String title) {
    	Show show = new Show(null, null, null, null);
    	
    	return show;
    }; // TODO
}
