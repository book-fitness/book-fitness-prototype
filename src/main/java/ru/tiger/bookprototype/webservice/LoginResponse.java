package ru.tiger.bookprototype.webservice;

import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
public class LoginResponse {

    private long id;
    private String login;

    public LoginResponse() {}
    
    public LoginResponse(User user) {
        this.id = user.getId();
        this.login = user.getUsername();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
