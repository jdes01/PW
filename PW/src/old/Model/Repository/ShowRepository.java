package old.Model.Repository;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import old.Model.Entities.Show.Show;

/**
 * Clase repositorio de los shows
 * 
 * @author Alberto Cano Turnes
 *
 */

public class ShowRepository {

	private String filename = "shows.bin";

	/**
	 * Funcion publica para guardar shows
	 * 
	 * @param show Show que se va a guardar
	 */

	public void saveShow(Show show) {
		ArrayList<Show> shows = new ArrayList<Show>();

		try {
			if (getShows() != null) {
				shows = getShows();
			}

			shows.add(show);
			ShowRepository.writeObjectsToFile(filename, shows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter de shows
	 * 
	 * @throws IOException Signals that an I/O of some sort has occured
	 */

	public ArrayList<Show> getShows() throws IOException {
		ArrayList<Show> shows = new ArrayList<Show>();
		Show show = new Show(null, null, null, null);
		boolean cont = true;
		try {
			FileInputStream file = new FileInputStream(filename);
			if (file.available() == 0) {
				file.close();
				return null;
			}
			ObjectInputStream input = new ObjectInputStream(file);
			while (cont) {
				show = (Show) input.readObject();
				if (show != null) {
					shows.add(show);
				} else {
					cont = false;
				}
			}
			input.close();
			file.close();
		} catch (EOFException e) {
			return shows;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return shows;
	}

	/**
	 * Funcion publica para cancelar un show
	 * @throws IOException 
	 */
	public void cancelShow(Show show) throws IOException {
		ArrayList<Show> shows = new ArrayList<Show>();
    	shows = getShows();
    	
    	Iterator<Show> it = shows.iterator();
    	while(it.hasNext()) {
    		Show tmpShow = (Show) it.next();
    		if(tmpShow.getTitle().equals(show.getTitle())) {
    			it.remove();
    		}
    	}
    	
    	ShowRepository.writeObjectsToFile(filename, shows);

	};

	/**
	 * Funcion publica para cancelar todos los show
	 * 
	 * @throws IOException
	 */

	public void cancelAllShows() throws IOException {
		ShowRepository.writeObjectsToFile(filename, null);
	};

	/**
	 * Funcion publica para obtener los shows por su titulo
	 * 
	 * @param title Titulo del show
	 */

	public Show getShowByTitle(String title) {
		ArrayList<Show> shows = new ArrayList<Show>();
    	Show show = null;
    	
    	try {
			shows = getShows();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	for(Show tmpShow : shows) {
    		if(tmpShow.getTitle().equals(title)) {
    			show = tmpShow;
    			break;
    		}
    	}
    	
		return show;
	}; // TODO

	private static void writeObjectsToFile(String filename, ArrayList<Show> shows) throws IOException {
		try {

			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream output = new ObjectOutputStream(file);

			if (shows == null) {
				output.writeObject(null);
			} else {
				for (Show show : shows) {
					output.writeObject(show);
				}
			}
			
			output.flush();
			if (output != null) {
				output.close();
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
