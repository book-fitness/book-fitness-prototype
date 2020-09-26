package ru.tiger.bookprototype.service.impl;

import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.LoginService;

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean checkPassword(String password, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLogged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

/*
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
        if (httpSession == null) {
            return false;
        }

        Object user = httpSession.getAttribute("user");
        if (user == null) {
            return false;
        }

        return true;
    }
*/
