package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ru.tiger.bookprototype.entity.CommentLike;

/**
 *
 * @author Igor
 */
public class CommentLikeDao extends AbstractLikeDao<CommentLike> { //как происходит передача параметра при наследовании. 

    public CommentLike findById(long userId, long commentId) {
        String jpql = "SELECT c FROM CommentLike c WHERE c.userId = :userId AND c.commentId =:commentId";
        TypedQuery<CommentLike> query = em.createQuery(jpql, CommentLike.class);
        query.setParameter("userId", userId);
        query.setParameter("commentId", commentId);
        return query.getSingleResult();
    }

    public List<CommentLike> findByUserId(long userId) {
        String jpql = "SELECT c FROM CommentLike c WHERE c.userId = :userId";
        TypedQuery<CommentLike> query = em.createQuery(jpql, CommentLike.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<CommentLike> findByCommentId(long commentId) {
        String jpql = "SELECT c FROM CommentLike c WHERE c.commentId = :commentId";
        TypedQuery<CommentLike> query = em.createQuery(jpql, CommentLike.class);
        query.setParameter("commentId", commentId);
        return query.getResultList();
    }

    public void remove(Long userId, Long commentId) {
        Query query = em.createQuery("DELETE FROM CommentLike c WHERE c.userId =:userId AND c.commentId =:commentId");
        query.setParameter("userId", userId);
        query.setParameter("commentId", commentId);
        query.executeUpdate();
    }
}


   /* public void setLike(User user, Comment comment, CommentLike commentLike) { //??
        commentLike.setUserId(user.getId());
        commentLike.setCommentId(comment.getId());
        em.persist(commentLike);
    }*/
