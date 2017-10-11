package ru.tiger.bookprototype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;
import ru.tiger.bookprototype.entity.Role;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.repository.RoleRepository;
import ru.tiger.bookprototype.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepo.findOne(1L);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepo.findByUsername(username);
        /*if (Hibernate.isInitialized(user.getRoles())) {
            Hibernate.initialize(user.getRoles());
        }*/
        return user;
    }
}
