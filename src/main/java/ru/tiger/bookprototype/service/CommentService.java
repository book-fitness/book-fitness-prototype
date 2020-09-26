package ru.tiger.bookprototype.service;

import java.util.List;
import ru.tiger.bookprototype.entity.Comment;

/**
 *
 * @author Igor
 */
public interface CommentService {

    List<Comment> findByUserId(long userId);
    
    List<Comment> findByArticleId(long articleId);
    
    Comment findById(long commentId);

    void create(Comment comment);

    void delete(Comment comment);

    void update(Comment comment);
}
