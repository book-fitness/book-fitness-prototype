package ru.tiger.bookprototype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;
import ru.tiger.bookprototype.dao.RoleDAO;
import ru.tiger.bookprototype.dao.UserDAO;
import ru.tiger.bookprototype.entity.Role;
import ru.tiger.bookprototype.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private RoleDAO roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        
        System.out.println("Юзер пытается заптсаться" + user);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (Hibernate.isInitialized(user.getRoles())) {
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }
}
