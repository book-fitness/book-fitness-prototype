package ru.tiger.bookprototype.dao;

import javax.ejb.Stateless;
import ru.tiger.bookprototype.entity.Comment;

/**
 *
 * @author Igor
 */
@Stateless
public class CommentDao extends AbstractDao<Comment> {

    public CommentDao() {
        super(Comment.class);
    }
}
