package ru.tiger.bookprototype.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.tiger.bookprototype.entity.User;

public interface LoginService {
    boolean checkPassword(String password, User user);
    void login(User user);
    void logout(User user);
    boolean isLogged();
}
