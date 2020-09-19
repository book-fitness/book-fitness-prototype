package ru.tiger.bookprototype.service.impl;

import java.util.List;
import javax.ejb.EJB;
import ru.tiger.bookprototype.dao.CommentDao;
import ru.tiger.bookprototype.entity.Comment;
import ru.tiger.bookprototype.service.CommentService;

/**
 *
 * @author Igor
 */
public class CommentServiceImpl implements CommentService {

    @EJB
    private CommentDao commentDao;

    @Override
    public List<Comment> findByUserId(long userId) {
        return (List<Comment>) commentDao.findById(userId);
    }

    @Override
    public List<Comment> findByArticleId(long articleId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Comment comment) {
        commentDao.saveOrUpdate(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentDao.remove(comment);
    }

    @Override
    public void update(Comment comment) {
        commentDao.saveOrUpdate(comment);
    }

    @Override
    public Comment findByCommentId(long commentId) {
        return commentDao.findById(commentId);
    }
}
