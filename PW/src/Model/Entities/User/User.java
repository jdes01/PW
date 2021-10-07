package Model.Entities;

/**
 * User
 */
public class User {

<<<<<<< HEAD:PW/src/Model/Entities/User.java
    private String nick;

=======
>>>>>>> 9e7a071c1da576755a950cf8c55e6240f147a90e:PW/src/Model/Entities/User/User.java
    private String name;

    private String nick

    private String mail;

    public User(String name, String nick, String mail){

        this.name = name;
    }

    public String getNick() {
        return this.nick;
    }

    public String getName() {
        return this.name;
    }

    public String getMail(){
        return this.mail;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail){
        this.mail = mail;
    }
}