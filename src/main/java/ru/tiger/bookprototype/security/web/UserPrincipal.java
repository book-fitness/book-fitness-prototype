package ru.tiger.bookprototype.security.web;

import java.security.Principal;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
public class UserPrincipal implements Principal {

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return user.getId();
    }

    @Override
    public String getName() {
        return user.getUsername();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
