package ru.tiger.bookprototype.service;

import javax.ws.rs.core.HttpHeaders;
import ru.tiger.bookprototype.entity.User;

public interface UserService {

    void save(User user);
    
    User findByLogin(String login);
    
    User findByUserId(Long id);
    
    User findByHeaders(HttpHeaders httpHeaders);
}

