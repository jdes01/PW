package refactor.Model.Entities;

import java.util.UUID;

/**
 * Clase usuario que tiene todo lo relacionado a los usuarios
 * 
 * @author Marcos Rodriguez Moreno
 */

public class User {

    private final String admin = "ADMIN";
    private final String viewer = "VIEWER";

    
    private UUID _id;
	private String _name;
    private String _lastName;
    private String _nickName;
    private String _mail;

    private String _role;

    public User(){}

   /**
    * Constructor de la clase usuario

    * @param name Nombre del usuario
    * @param lastName Apellido del usuario
    * @param nickName Nick del usuario
    * @param mail Mail del usuario
    */

    public User(String name, String lastName, String nickName, String mail){

        UUID uuid = UUID.randomUUID();
        this._id = uuid;

        this._name = name;
        this._lastName = lastName;
        this._nickName = nickName;
        this._mail = mail;

        this._role = viewer;
    }



    
    /** 
     * Getter del ID
     * 
     * @return UUID
     */
    public UUID getUuid(){
        return this._id;
    }

    
    /** 
     * Getter del nombre
     * 
     * @return String
     */
    public String getName() {
        return this._name;
    }

    
    /** 
     * Getter del apellido
     * 
     * @return String
     */
    public String getLastName() {
        return this._lastName;
    }

    
    /** 
     * Getter del nick
     * 
     * @return String
     */
    public String getNickName(){
        return this._nickName;
    }

    
    /** 
     * Getter del mail
     * 
     * @return String
     */
    public String getMail(){
        return this._mail;
    }

    
    /** 
     * Getter del rol
     * 
     * @return String
     */
    public String getRole(){
        return this._role;
    }



    
    /** 
     * Setter del ID
     * 
     * @param id ID del usuario
     */
    public void setID(String id) {
        this._id = UUID.fromString(id);
    }

    
    /** 
     * Setter del nombre
     * 
     * @param name Nombre del usuario
     */
    public void setName(String name) {
        this._name = name;
    }

    
    /** 
     * Setter del apellido
     * 
     * @param lastName Apellido del usuario
     */ 
    public void setLastName(String lastName) {
        this._lastName = lastName;
    }

    
    /** 
     * Setter del nick
     * 
     * @param nickName Nick del usuario
     */
    public void setNickName(String nickName){
        this._nickName = nickName;
    }

    
    /** 
     * Setter del mail
     * 
     * @param mail Mail del usuario
     */
    public void setMail(String mail){
        this._mail = mail;
    }

    /**
     * Setter del rol del administrador
     */

    public void setRoleAdmin(){
        this._role = this.admin;
    }

    /**
     * Setter del rol del viewer
     */

    public void setRoleViewer(){
        this._role = this.viewer;
    }

}