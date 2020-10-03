package ru.tiger.bookprototype.webservice;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
@RequestScoped
public class SessionContext {
    
    private static final String USER = "user";
    
    private HttpSession session;

    public SessionContext() {}
    
    @Inject
    public SessionContext(HttpSession session) {
        this.session = session;
    }
    
    public User getUser() {
        return (User) session.getAttribute(USER);
    }
    
    public void setUser(User user) {
        session.setAttribute(USER, user);
    }
    
    public boolean hasLoggedIn() {
        return session.getAttribute(USER) != null;
    }
    
    public void logout() {
        session.setAttribute(USER, null);
        session.invalidate();
    }
}
