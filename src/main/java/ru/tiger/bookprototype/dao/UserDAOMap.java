/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tiger.bookprototype.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Игорь
 */
public class UserDAOMap implements UserDAO {
    
    private static Map<String, User> users = new HashMap<String, User>();
    
    @Override
    public boolean exist(User user) {
        return users.containsKey(user.getLogin());
        
    }

    @Override
    public List<User> findAll() {
        //.map(entry -> entry.getValue())
        /*Function f;
        List<User> list = users
            .entrySet()
            .stream()
            .collect(Collectors.toList());*/
        
        List<User> list = new ArrayList<>();
        
        for (Map.Entry<String, User> entry : users.entrySet()) {
            list.add(entry.getValue());
        }
        
        return list;
    }

    @Override
    public User findById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(User user) {
        users.put(user.getLogin(), user);
    }

    @Override
    public User findByLogin(String login) {
        return users.get(login);
    }
    
}
