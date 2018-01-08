package ua.com.shocell.DAO;

import ua.com.shocell.models.WebPortalUser;

import java.util.List;

public interface WebPortalUserDAO{
    public List<WebPortalUser> findByLogin(String login);

    public List<WebPortalUser> findByEmail(String email);

    public List<WebPortalUser> findByEnabled(Boolean enabledStatus);

}
