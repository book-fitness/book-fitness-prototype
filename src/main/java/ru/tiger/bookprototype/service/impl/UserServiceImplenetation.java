
package ru.tiger.bookprototype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.UserService;

@Service
@Transactional
public class UserServiceImplenetation implements UserService {
    
    @Autowired
    private UserDao userDao;

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
}
