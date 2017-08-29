package ru.tiger.bookprototype.service;

import javax.servlet.http.HttpSession;
import ru.tiger.bookprototype.entity.User;

public class LoginServiceImpl implements LoginService {

    private HttpSession httpSession;
    
    public LoginServiceImpl(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
    
    @Override
    public boolean checkPassword(String password, User user) {
        return user.getPassword().equals(password);
    }

    @Override
    public void login(User user) {
        httpSession.setAttribute("user", user);
    }

    @Override
    public void logout(User user) {
        httpSession.removeAttribute("user");
    }

    @Override
    public boolean isLogged() {
        if (httpSession == null) return false;
        
        Object user = httpSession.getAttribute("user");
        if (user == null) return false;
        
        return true;
    }
}
