package ru.tiger.bookprototype.service;

import ru.tiger.bookprototype.entity.User;

public interface LoginService {

    boolean checkPassword(String password, User user);

    void login(User user);

    void logout(User user);

    boolean isLogged();
}
