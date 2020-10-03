package ru.tiger.bookprototype.service.impl;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.LoginService;

@ApplicationScoped
public class LoginServiceImpl implements LoginService {
    @EJB
    private UserDao userDao;
    
    @Override
    public User tryToLogin(String login, String password) {
        User user = userDao.findByLogin(login);
        return user.checkPassword(password) ? user : null;
    }
}
