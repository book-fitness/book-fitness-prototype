package ru.tiger.bookprototype.service;

import ru.tiger.bookprototype.entity.Comment;

/**
 *
 * @author Igor
 */
public interface CommentService {

    Comment findByUserId(long userId);
    
    Comment findByArticleId(long articleId);

    void create(Comment comment);

    void delete(Comment comment);

    void update(Comment comment);
}
