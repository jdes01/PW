package old.Model.Entities;

import java.io.Serializable;

/**
 * Clase usuario que tiene todo lo relacionado a los usuarios
 * @author Marcos Rodriguez Moreno
 */

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String _fullname;

    private String _username;

    private String _mail;
    
   /**
    * Constructor de la clase usuario
    * @param name Nombre del usuario
    * @param nick NIck del usuario
    * @param mail Mail del usuario
    */

    public User(String name, String nick, String mail){

        this._fullname = name;
        this._username = nick;
        this._mail = mail;
    }
    
   /**
    * Getter del nick del usuario
    * @return Retorna el nick del usuario
    */

    public String getUsername() {
        return this._username;
    }
    
/**
 * Getter del nombre del usuario
 * @return Retorna el nombre del usuario
 */

    public String getName() {
        return this._fullname;
    }
    
/**
 * Getter del mail del usuario
 * @return Retorna el mail del usuario
 */

    public String getMail(){
        return this._mail;
    }
    
/**
 * Setter del nick del usuario
 * @param nick Nick del usuario
 */

    public void setUsername(String nick) {
        this._username = nick;
    }
    
/**
 * Setter del nombre del usuario
 * @param name Nombre del usuario
 */

    public void setName(String name) {
        this._fullname = name;
    }
    
/**
 * Setter del mail del usuario
 * @param mail Mail del usuario
 */

    public void setMail(String mail){
        this._mail = mail;
    }
}
