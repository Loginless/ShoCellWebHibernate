package ua.com.shocell.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WebPortalUser {

    @Id
    private int userID;
    private String login;
    private String password;
    private String email;


    public WebPortalUser() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
