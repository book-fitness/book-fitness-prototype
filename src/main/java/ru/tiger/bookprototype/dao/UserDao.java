package ru.tiger.bookprototype.dao;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
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
  
    public User findByLogin(String login) {
        String jpql = "SELECT u FROM User u WHERE u.username = :login";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }
}