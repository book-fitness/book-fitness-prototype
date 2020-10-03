package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ru.tiger.bookprototype.entity.BookLike;

/**
 *
 * @author Igor
 */
@Stateless
public class BookLikeDao extends AbstractLikeDao<BookLike> {

    @PersistenceContext
    private EntityManager em;

    public BookLike findById(long userId, long bookId) {
        String jpql = "SELECT b FROM BookLike b WHERE b.userId = :userId AND b.bookId = :articleId";
        TypedQuery<BookLike> query = em.createQuery("SELECT b FROM BookLike b WHERE b.userId = :userId AND b.bookId = :bookId", BookLike.class);
        query.setParameter("userId", userId);
        query.setParameter("bookId", bookId);
        return query.getSingleResult();
    }

    public List<BookLike> findByUserId(long userId) {
        String jpql = "SELECT b FROM BookLike b WHERE b.userId = :userId";
        TypedQuery<BookLike> query = em.createQuery(jpql, BookLike.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<BookLike> findByBookId(long bookId) {
        String jpql = "SELECT b FROM BookLike b WHERE b.bookId = :bookId";
        TypedQuery<BookLike> query = em.createQuery(jpql, BookLike.class);
        query.setParameter("bookId", bookId);
        return query.getResultList();
    }

    public void remove(Long userId, Long bookId) {
        Query query = em.createQuery("DELETE FROM BookLike b WHERE b.userId =:userId AND b.bookId =:bookId");
        query.setParameter("userId", userId);
        query.setParameter("bookId", bookId);
        query.executeUpdate();
    }
}
