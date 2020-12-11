
package ru.tiger.bookprototype.service.impl;

import javax.ws.rs.core.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tiger.bookprototype.dao.TokenDao;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.Token;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.UserService;

@Service
@Transactional
public class UserServiceImplenetation implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private TokenDao tokenDao;

    @Override
    public void save(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    } 

    @Override
    public User findByUserId(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByHeaders(HttpHeaders httpHeaders) {
        String authorizationHeader = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
        String AUTHENTICATION_SCHEME = "Basic";
        String tokenValue = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
        Token token = tokenDao.findByTokenValue(tokenValue);
        return userDao.findById(token.getUserId());
    }
}
