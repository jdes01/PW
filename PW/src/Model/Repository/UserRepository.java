package Model.Repository;

import java.io.File;  //?
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import Model.Entities.User.User;

/**
 * Clase repositorio de los usuarios
 * @author Javier De Santiago Palomino
 *
 */

public class UserRepository {

/**
 * 	Funcion publica que guarda el usuario
 * @param user El Usuario que se guarda
 * @throws IOException Signals that an I/O of some sort has occured
 */
	
    public void saveUser(User user) throws IOException {
        try {
        	FileOutputStream file = new FileOutputStream(new File("users.txt"));
        	ObjectOutputStream output = new ObjectOutputStream(file);
        	
        	output.writeObject(user);
        	
        	output.close();
        	file.close();
        } catch (FileNotFoundException error) {
        	error.printStackTrace();
        } catch (IOException error) {
        	error.printStackTrace();
        }
    }

/**
 * Getter de usuarios
 * @return Retorna los usuarios
 * @throws EOFException Signals that an end of file or end of stream has been reached unexpectedly during input
 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:<p>

    The forName method in class Class<p>
    The findSystemClass method in class ClassLoader<p>
    The loadClass method in class ClassLoader
 */
    
    @SuppressWarnings("null")
	public ArrayList<User> getUsers() throws EOFException, ClassNotFoundException {
    	ArrayList<User> users = null;
    	
    	try {
	    	FileInputStream file = new FileInputStream(new File("users.txt"));
	    	ObjectInputStream input = new ObjectInputStream(file);
	    	
	    	while(true) {
	    		try {
	    			users.add((User) input.readObject());
	    		} catch (EOFException error) {
	    			input.close();
	    			file.close();
	    			return users;
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
    	
    	return users;
	}
/**
 * Funcion pública que borra el usuario
 * @param user Usuario
 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:<p>

    The forName method in class Class<p>
    The findSystemClass method in class ClassLoader<p>
    The loadClass method in class ClassLoader
 * @throws IOException Signals that an I/O of some sort has occured
 */
    public void deleteUser(User user) throws ClassNotFoundException, IOException {
    	ArrayList<User> users = null;
    	try {
    		 users = getUsers();
    	} catch (ClassNotFoundException error) {
    		error.printStackTrace();
    	}
    	
    	users.remove(user);
    	writeObjectsToFile("users.txt", users);
    }
    
/**
 * Funcion publica que obtiene el usuario por el nombre
 * @param name Nombre del usuario
 * @return null
 */
    
    public User getUserByName(String name) {
    	try {
	    	FileInputStream file = new FileInputStream(new File("users.txt"));
	    	@SuppressWarnings("resource")
			ObjectInputStream input = new ObjectInputStream(file);
	    	
	    	while(true) {
	    		try {
	    			User user = (User) input.readObject();
	    			if(user.getName() == name) {
	    				return user;
	    			}
;	    		} catch (EOFException error) {
	    			return null;
	    		} catch (ClassNotFoundException error) {
	    			error.printStackTrace();
	    		}
	    	}
    	} catch (FileNotFoundException error) {
        	error.printStackTrace();
        } catch (IOException error) {
        	error.printStackTrace();
        }
    	
		return null;
	}

/**
 * Funcion privada que reescribe el fichero cuando borra un objeto
 * @param filename Nombre del fichero
 * @param objects Objetos
 * @throws IOException Signals that an I/O of some sort has occured
 */

	private static void writeObjectsToFile(String filename, ArrayList<User> objects) throws IOException {
        OutputStream os = null;
        try {
          os = new FileOutputStream(filename);
          @SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(os);
          for (Object object : objects) {
            oos.writeObject(object);
          }
          oos.flush();
        } finally {
          if (os != null) {
            os.close();
          }
        }
      }
}
