package Model.Entities.User;

import java.io.Serializable;

/**
 * Clase usuario que tiene todo lo relacionado a los usuarios
 * @author Marcos Rodriguez Moreno
 */

public class User implements Serializable {

    private String name;

    private String nick;

    private String mail;
    
   /**
    * Constructor de la clase usuario
    * @param name Nombre del usuario
    * @param nick NIck del usuario
    * @param mail Mail del usuario
    */

    public User(String name, String nick, String mail){

        this.name = name;
    }
    
   /**
    * Getter del nick del usuario
    * @return Retorna el nick del usuario
    */

    public String getNick() {
        return this.nick;
    }
    
/**
 * Getter del nombre del usuario
 * @return Retorna el nombre del usuario
 */

    public String getName() {
        return this.name;
    }
    
/**
 * Getter del mail del usuario
 * @return Retorna el mail del usuario
 */

    public String getMail(){
        return this.mail;
    }
    
/**
 * Setter del nick del usuario
 * @param nick Nick del usuario
 */

    public void setNick(String nick) {
        this.nick = nick;
    }
    
/**
 * Setter del nombre del usuario
 * @param name Nombre del usuario
 */

    public void setName(String name) {
        this.name = name;
    }
    
/**
 * Setter del mail del usuario
 * @param mail Mail del usuario
 */

    public void setMail(String mail){
        this.mail = mail;
    }
}