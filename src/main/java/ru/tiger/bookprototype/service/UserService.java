package ru.tiger.bookprototype.service;

import ru.tiger.bookprototype.entity.User;

public interface UserService {

    void save(User user);
    
    User findByLogin(String login);
    
    User findByUserId(Long id);
}

