package ru.tiger.bookprototype.service;

import java.util.List;

/**
 *
 * @author Igor
 */
public interface ArticleService<T> {
    
    List<T> findByUserId(long userId);

    void create(T article);

    void update(T article);

    void delete(T article);
    
    List<T> findAll();
}
