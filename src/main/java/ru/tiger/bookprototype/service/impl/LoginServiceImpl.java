package ru.tiger.bookprototype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;
    
    @Override
    public User tryToLogin(String login, String password) {
        User user = userDao.findByLogin(login);
        if (user == null) throw new RuntimeException("User not found");
        if (!user.checkPassword(password)) new RuntimeException("Wrong password");
        return user;
    }
}
