package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.entity.ArticleLike;

/**
 *
 * @author Igor
 */
@Service
public class ArticleLikeDao extends AbstractLikeDao<ArticleLike>{

    public ArticleLike findById(long userId, long articleId) {
        String jpql = "SELECT a FROM ArticleLike a WHERE a.userId = :userId AND a.articleId = :articleId";
        TypedQuery<ArticleLike> query = em.createQuery(jpql, ArticleLike.class);
        query.setParameter("userId", userId);
        query.setParameter("articleId", articleId);
        return query.getSingleResult();
    }

    public List<ArticleLike> findByUserId(long userId) {
        String jpql = "SELECT a FROM ArticleLike a WHERE a.userId = :userId";
        TypedQuery<ArticleLike> query = em.createQuery(jpql, ArticleLike.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<ArticleLike> findByArticleId(long articleId) {
        String jpql = "SELECT a FROM ArticleLike a WHERE a.articleId = :articleId";
        TypedQuery<ArticleLike> query = em.createQuery(jpql, ArticleLike.class);
        query.setParameter("userId", articleId);
        return query.getResultList();
    }
    
    public void remove(Long userId, Long articleId) {
        String jpql = "DELETE FROM ArticleLike a WHERE a.userId = :userID AND a.articleId = :articleId";
        Query query = em.createQuery(jpql);
        query.setParameter("userId", userId);
        query.setParameter("articleId", articleId);
        query.executeUpdate();
    }
}
