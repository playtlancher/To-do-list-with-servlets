package models;

import lombok.Data;
import utills.DataBaseConnection;
import utills.PasswordHasher;

@Data
public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public boolean isValidUser() {
        DataBaseConnection con = new DataBaseConnection();
        PasswordHasher hasher = new PasswordHasher();
        String hashedPassword = con.getData(name, "password");
        return hasher.checkPassword(password, hashedPassword);
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
