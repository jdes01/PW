package Model.Entities.User;

/**
 * User
 */

public class User {

    private String name;

    private String nick;

    private String mail;
    
   /**
    * 
    * @param name
    * @param nick
    * @param mail
    */

    public User(String name, String nick, String mail){

        this.name = name;
    }
    
   /**
    * 
    * @return
    */

    public String getNick() {
        return this.nick;
    }
    
/**
 * 
 * @return
 */

    public String getName() {
        return this.name;
    }
    
/**
 *     
 * @return
 */

    public String getMail(){
        return this.mail;
    }
    
/**
 *     
 * @param nick
 */

    public void setNick(String nick) {
        this.nick = nick;
    }
    
/**
 *     
 * @param name
 */

    public void setName(String name) {
        this.name = name;
    }
    
/**
 *     
 * @param mail
 */

    public void setMail(String mail){
        this.mail = mail;
    }
}