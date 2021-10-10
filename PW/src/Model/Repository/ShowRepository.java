package Model.Repository;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import Model.Entities.Show.Show;

public class ShowRepository {
 
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

    public void cancelShow(Show show);

    public void cancelAllShows();
    
}
