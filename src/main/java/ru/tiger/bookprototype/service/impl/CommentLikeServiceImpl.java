package ru.tiger.bookprototype.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.dao.CommentLikeDao;
import ru.tiger.bookprototype.entity.CommentLike;
import ru.tiger.bookprototype.service.CommentLikeService;

/**
 *
 * @author Igor
 */
@Stateless
public class CommentLikeServiceImpl implements CommentLikeService {

    @EJB
    private CommentLikeDao commentLikeDao;

    private void setLikeOrDislike(Long userId, Long commentId, boolean value) {

        CommentLike commentLike = commentLikeDao.findById(userId, commentId);
        if (commentLike == null) {
            commentLikeDao.create(new CommentLike(userId, commentId, value));
        } else {
            commentLike.setValue(value);
            commentLikeDao.update(commentLike);
        }
    }

    private void unsetLikeOrDislike(long userId, long articleId) {
        CommentLike commentLike = commentLikeDao.findById(userId, articleId);
        if (commentLike == null) {
            System.out.println("Was not found");
        } else {
            commentLikeDao.remove(commentLike);
        }
    }

    @Override
    public void like(long userId, long commentId) {
        setLikeOrDislike(userId, commentId, true);
    }

    @Override
    public void dislike(long userId, long commentId) {
        setLikeOrDislike(userId, commentId, false);
    }

    @Override
    public void unsetLike(long userId, long commentId) {
        unsetLikeOrDislike(userId, commentId);
    }

    @Override
    public void unsetDislike(long userId, long commentId) {
        unsetLikeOrDislike(userId, commentId);
    }
}
