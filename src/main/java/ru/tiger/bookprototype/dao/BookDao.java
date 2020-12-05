package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import ru.tiger.bookprototype.entity.Book;

/**
 *
 * @author Igor
 */
@Stateless
public class BookDao extends AbstractDao<Book> {

    public BookDao() {
        super(Book.class);
    }

    public List<Book> findByUserId(Long userId) {
        String jpql = "SELECT b FROM Book b WHERE b.publisher.id = :userId";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
