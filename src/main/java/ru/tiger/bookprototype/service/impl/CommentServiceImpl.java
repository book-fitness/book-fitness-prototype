package ru.tiger.bookprototype.service.impl;

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
    public Comment findByUserId(long userId) {
        return commentDao.findById(userId);
    }

    @Override
    public Comment findByArticleId(long articleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
