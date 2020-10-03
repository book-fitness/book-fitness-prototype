package ru.tiger.bookprototype.service;

import ru.tiger.bookprototype.entity.User;

public interface LoginService {
    User tryToLogin(String login, String password);
}
