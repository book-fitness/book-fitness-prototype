package ru.tiger.bookprototype.dao;

import java.util.List;
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
        List<User> result = query.getResultList();
        return result != null && !result.isEmpty() ? result.get(0) : null;
    }
}