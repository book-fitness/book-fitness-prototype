package ru.tiger.bookprototype.dao;

import javax.ejb.Stateless;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
@Stateless
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }
}