import User;

import org.json.simple.JSONObject;

import java.io.File;  
import java.io.FileWriter;  

public class UserRepository {

    private File userFile = new File("userFile.json");
    
    public void saveUser(User user){

        JSONObject userList = new JSONObject(); 

        userList.put("name", user.name);

        //todo add all atributes

        userFile.createNewFile();  

        FileWriter fileWriter = new FileWriter(userFile);  

        fileWriter.write(userFile.toJSONString());  
        fileWriter.flush();  
        fileWriter.close();  
    }

    public ArrayList<User> getUsers(){} //TODO

    public void deleteUser(User user){} //TODO

    public User getUserByName(String name){} //TODO
}
