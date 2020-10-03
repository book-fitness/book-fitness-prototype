package ru.tiger.bookprototype.service.impl;

import javax.servlet.http.HttpSession;
import ru.tiger.bookprototype.entity.User;

public class LoginServiceImpl_Old {

    private HttpSession httpSession;

    public LoginServiceImpl_Old(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public boolean checkPassword(String password, User user) {
        return user.getPassword().equals(password);
    }

    public void login(User user) {
        httpSession.setAttribute("user", user);
    }

    public void logout(User user) {
        httpSession.removeAttribute("user");
    }

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
}
