package ru.tiger.bookprototype.service;

import java.util.List;

/**
 *
 * @author Igor
 */
public interface CommentService<T> {

    List<T> findByUserId(long userId);
    
    List<T> findByArticleId(long articleId);

    void create(T comment);

    void delete(T comment);

    void update(T comment);
}
