package ru.tiger.bookprototype.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.dao.CommentDao;
import ru.tiger.bookprototype.entity.Comment;
import ru.tiger.bookprototype.service.CommentService;

/**
 *
 * @author Igor
 */
@Stateless
public class CommentServiceImpl implements CommentService {

    @EJB
    private CommentDao commentDao;

    @Override
    public void create(Comment comment) {
        commentDao.saveOrUpdate(comment);
    }

    @Override
    public Comment findById(long commentId) {
        return commentDao.findById(commentId);
    }

    @Override
    public List<Comment> findByUserId(long userId) {
        return commentDao.findByUserId(userId);
    }

    @Override
    public List<Comment> findByArticleId(long articleId) {
        return commentDao.findByArticleId(articleId);
    }

    @Override
    public void update(Comment comment) {
        commentDao.saveOrUpdate(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentDao.remove(comment);
    }
}
