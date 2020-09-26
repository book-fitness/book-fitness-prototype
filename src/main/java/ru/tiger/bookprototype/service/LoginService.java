package ru.tiger.bookprototype.service;

import ru.tiger.bookprototype.entity.User;

public interface LoginService {

    boolean checkPassword(String password, User user);

    User login(String login, String password);

    void logout(String login);

    boolean isLogged();
}
