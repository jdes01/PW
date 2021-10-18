package Model.Repository;

import java.io.File;  //?
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
    public void saveUser(User user) throws IOException, ClassNotFoundException {
    	ArrayList<User> users = new ArrayList<User>();
    	
    	try {
    		FileOutputStream file = new FileOutputStream("users.txt");
    		ObjectOutputStream output = new ObjectOutputStream(file);
    		users = getUsers();
    		
    		users.add(user);
    		for(User usertmp : users) {
    			output.writeObject(usertmp);
    		}
    		
    		output.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }

/**
 * Getter de usuarios
 * @return Retorna los usuarios
 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using:<p>

    The forName method in class Class<p>
    The findSystemClass method in class ClassLoader<p>
    The loadClass method in class ClassLoader
 * @throws IOException 
 */
    
	public ArrayList<User> getUsers() throws IOException {
    	ArrayList<User> users = new ArrayList<User>();
    	boolean cont = true;
    	try {
    		FileInputStream file = new FileInputStream("users.txt");
    		ObjectInputStream input = new ObjectInputStream(file);
    		while(cont) {
    			User user = (User) input.readObject();
    			if(user != null) {
    				users.add(user);
    			} else {
    				cont = false;
    			}
    		}
    		input.close();
    	} catch(EOFException e) {
    		return users;
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
    	users = getUsers();
    	
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

	private static void writeObjectsToFile(String filename, ArrayList<User> users) throws IOException {
		try {
          FileOutputStream file = new FileOutputStream(filename, true);
          ObjectOutputStream output = new ObjectOutputStream(file);
          output.writeObject(users);
          output.flush();
          if (output != null) {
        	  output.close();
          }
        } catch (Exception e) {
        	e.printStackTrace();
        }
      }
}
