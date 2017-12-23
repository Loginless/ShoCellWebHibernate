package ua.com.shocell.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "WEBPORTAL_USER_ROLES")
public class WebPortalUserRole {

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private int roleID;

    @Column(name = "ROLE_NAME", nullable = false)
    private String role_name;

    @OneToMany(mappedBy = "webPortalUserRole")
    Collection<WebPortalUser> webPortalUsers = new ArrayList<WebPortalUser>();

    public WebPortalUserRole() {
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Collection<WebPortalUser> getWebPortalUsers() {
        return webPortalUsers;
    }

    public void setWebPortalUsers(Collection<WebPortalUser> webPortalUsers) {
        this.webPortalUsers = webPortalUsers;
    }

    @Override
    public String toString() {
        return "WebPortalUserRole{" +
                "roleID=" + roleID +
                ", role_name='" + role_name + '\'' +
                ", webPortalUsers=" + webPortalUsers +
                '}';
    }
}
