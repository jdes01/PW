package Repository;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.json.JSONObject;
import Model.Entities.User;

public class UserRepository {
    
	private static FileWriter file;
	
	
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
    
    public ArrayList<User> getUsers() throws EOFException, ClassNotFoundException {
    	ArrayList<User> users = null;
    	
    	try {
	    	FileInputStream file = new FileInputStream(new File("users.txt"));
	    	ObjectInputStream input = new ObjectInputStream(file);
	    	
	    	while(true) {
	    		try {
	    			users.add((User) input.readObject());
	    		} catch (EOFException error) {
	    			return users;
	    		} catch (ClassNotFoundException error) {
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
    
    public void deleteUser(User user) {}
    
    public User getUserByName(String name) {
    	try {
	    	FileInputStream file = new FileInputStream(new File("users.txt"));
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
}
