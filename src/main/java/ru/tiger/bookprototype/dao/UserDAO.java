/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tiger.bookprototype.dao;

import java.util.List;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Игорь
 */
public interface UserDAO {
    boolean exist(User user);
    List<User> findAll();
    User findById(int Id);
    User findByLogin(String login);
    void create(User user);
}
