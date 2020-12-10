package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.entity.Comment;

/**
 *
 * @author Igor
 */
@Service
public class CommentDao extends AbstractDao<Comment> {

    public CommentDao() {
        super(Comment.class);
    }

    public List<Comment> findByArticleId(Long articleId) {
        String jpql = "SELECT c FROM Comment c WHERE c.articleId = :articleId";
        TypedQuery<Comment> query = entityManager.createQuery(jpql, Comment.class);
        query.setParameter("articleId", articleId);
        return query.getResultList();
    }

    public List<Comment> findByUserId(Long userId) {
        String jpql = "SELECT c FROM Comment c WHERE c.userId = :userId";
        TypedQuery<Comment> query = entityManager.createQuery(jpql, Comment.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
