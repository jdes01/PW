package Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import Model.Entities.User;

public class UserRepository {
    
	private static FileWriter file;
	
	
    public void saveUser(User user) throws IOException {
        JSONObject object = new JSONObject();
        object.put("nick", user.getNick());
        object.put("name", user.getName());
        object.put("mail", user.getMail());
        
        try {
	        file = new FileWriter("./users.txt");
	        file.write(object.toString());
        } catch(IOException error) {
        	error.printStackTrace();
        } finally {
        	try {
        		file.flush();
        		file.close();
        	} catch(IOException error) {
        		error.printStackTrace();
        	}
        }
    }
    
    public ArrayList<User> getUsers() {
    	return null;
	}
    
    public void deleteUser(User user) {}
    
    public User getUserByName(String name) {
		return null;
	}
}
