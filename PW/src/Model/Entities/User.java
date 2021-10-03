package Model;

/**
 * User
 */
public class User {

    private String nick

    private String name;

    public User(String name){

        this.name = name;
    }

    public String getNick() {
        return this.nick;
    }

    public String getName() {
        return this.name;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setName(String name) {
        this.name = name;
    }
}