package ua.com.shocell.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "WEBPORTAL_USERS")
public class WebPortalUser {

    private static final Logger LOGGER = LogManager.getLogger("ua.com.shoCell.models");


    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private int userID;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled;

    @ManyToOne()
    @JoinColumn(name = "WEBUSER_ROLE_ID")
    private WebPortalUserRole webPortalUserRole;

    @OneToMany(mappedBy = "webPortalUserID", fetch = FetchType.EAGER)
    Collection<Abonent> abonentsList = new ArrayList<Abonent>();


    public WebPortalUser() {

        LOGGER.info("WebPortal user constructor is created");

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public WebPortalUserRole getWebPortalUserRole() {
        return webPortalUserRole;
    }

    public void setWebPortalUserRole(WebPortalUserRole webPortalUserRole) {
        this.webPortalUserRole = webPortalUserRole;
    }

    public Collection<Abonent> getAbonentsList() {
        return abonentsList;
    }

    public void setAbonentsList(Collection<Abonent> abonentsList) {
        this.abonentsList = abonentsList;
    }

    @Override
    public String toString() {
        return "WebPortalUser{" +
                "userID=" + userID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", webPortalUserRole=" + webPortalUserRole +
                ", abonentsList=" + abonentsList +
                '}';
    }
}
