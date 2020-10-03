package ru.tiger.bookprototype.webservice;

import javax.servlet.http.HttpSession;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
public class SessionContext {
    
    private static final String USER = "user";
    
    private HttpSession session;

    public SessionContext(HttpSession session) {
        this.session = session;
    }
    
    public User getUser() {
        return (User) session.getAttribute(USER);
    }
    
    public void setUser(User user) {
        session.setAttribute(USER, user);
    }
}
