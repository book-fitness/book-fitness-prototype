
package ru.tiger.bookprototype.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.UserService;

@Stateless
public class UserServiceImplenetation implements UserService {
    
    @EJB
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
