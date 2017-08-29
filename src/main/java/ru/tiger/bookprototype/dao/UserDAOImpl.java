package ru.tiger.bookprototype.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.tiger.bookprototype.entity.User;

public class UserDAOImpl implements UserDAO {
    
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    @Override
    public boolean exist(User user) {
        return findByLogin(user.getLogin()) != null;
    }

    @Override
    public List<User> findAll() {
        Query<User> query =  session.createQuery("from User");
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    public User findById(int id) {
        return session.find(User.class, (long) id);
    }

    @Override
    public User findByLogin(String login) {
        Query<User> query =  session.createQuery("from User where login = ?").setParameter(0, login);
        List<User> userList = query.getResultList();
        return userList.size() > 0 ? userList.get(0) : null;
    }

    @Override
    public void create(User user) {
        session.save(user);
    }
    
}
