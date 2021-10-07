package Model.Entities;

/**
 * User
 */
public class User {

    private String nick;

    private String name;

    private String mail;

    public User(String name){

        this.name = name;
    }

    public String getNick() {
        return this.nick;
    }

    public String getName() {
        return this.name;
    }

    public String getMail() {
        return this.mail;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}