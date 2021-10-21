package Model.Repository;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import Model.Entities.User;

/**
 * Clase repositorio de los usuarios
 * @author Javier De Santiago Palomino
 *
 */

public class UserRepository {
	
	private String filename = "users.bin";

/**
 * 	Funcion publica que guarda el usuario
 * @param user El Usuario que se guarda
 * @throws IOException Signals that an I/O of some sort has occured
 */
	
    public void saveUser(User user) throws IOException, ClassNotFoundException {
    	ArrayList<User> users = new ArrayList<User>();
    	
    	try {
    		if(getUsers() != null) {
    			users = getUsers();
    		}
    		
    		users.add(user);
    		UserRepository.writeObjectsToFile(filename, users);
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
    	User user = new User(null, null, null);
    	boolean cont = true;
    	try {
    		FileInputStream file = new FileInputStream(filename);
    		if(file.available() == 0) {
    			file.close();
    			return null;
    		}
    		ObjectInputStream input = new ObjectInputStream(file);
    		while(cont) {
    			user = (User) input.readObject();
    			if(user != null) {
    				users.add(user);
    			} else {
    				cont = false;
    			}
    		}
    		input.close();
    		file.close();
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
    	ArrayList<User> users = new ArrayList<User>();
    	users = getUsers();
    	
    	Iterator<User> it = users.iterator();
    	while(it.hasNext()) {
    		User tmpuser = (User) it.next();
    		if(tmpuser.getName().equals(user.getName())) {
    			it.remove();
    		}
    	}
    	
    	UserRepository.writeObjectsToFile(filename, users);
    }
    
/**
 * Funcion publica que obtiene el usuario por el nombre
 * @param name Nombre del usuario
 * @return null
 */
    
    public User getUserByName(String name) {
    	ArrayList<User> users = new ArrayList<User>();
    	User user = null;
    	
    	try {
			users = getUsers();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	for(User tmpUser : users) {
    		if(tmpUser.getName().equals(name)) {
    			user = tmpUser;
    			break;
    		}
    	}
    	
		return user;
	}

/**
 * Funcion privada que reescribe el fichero cuando inserta o borra un objeto
 * @param filename Nombre del fichero
 * @param objects Objetos
 * @throws IOException Signals that an I/O of some sort has occured
 */

	private static void writeObjectsToFile(String filename, ArrayList<User> users) throws IOException {
		try {
			
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);
            
            if (users == null) {
				output.writeObject(null);
			} else {
				for (User user : users) {
					output.writeObject(user);
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
