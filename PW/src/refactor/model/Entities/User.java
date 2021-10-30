package refactor.model.Entities;

import java.util.UUID;

public class User {

    private final String admin = "ADMIN";
    private final String viewer = "VIEWER";

    
    private UUID _id;
	private String _name;
    private String _lastName;
    private String _nickName;
    private String _mail;

    private String _role;


    public User(String name, String lastName, String nickName, String mail){

        UUID uuid = UUID.randomUUID();
        this._id = uuid;

        this._name = name;
        this._lastName = lastName;
        this._nickName = nickName;
        this._mail = mail;

        this._role = viewer;
    }



    public UUID getUuid(){
        return this._id;
    }

    public String getName() {
        return this._name;
    }

    public String getLastName() {
        return this._lastName;
    }

    public String getNickName(){
        return this._nickName;
    }

    public String getMail(){
        return this._mail;
    }

    public String getRole(){
        return this._role;
    }



    public void setName(String name) {
        this._name = name;
    }

    public void setLastName(String lastName) {
        this._lastName = lastName;
    }

    public void setNickName(String nickName){
        this._nickName = nickName;
    }

    public void setMail(String mail){
        this._mail = mail;
    }

    public void setRoleAdmin(){
        this._role = this.admin;
    }

    public void setRoleViewer(){
        this._role = this.viewer;
    }

}

