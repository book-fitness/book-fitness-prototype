package ru.tiger.bookprototype.webservice;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
@Service
@Scope("request")
@Deprecated
public class SessionContext {
    
    private static final String USER = "user";
    
    private HttpSession session;

    public SessionContext() {}
    
    @Autowired
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
