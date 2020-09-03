package ru.tiger.bookprototype.service;

import java.util.List;

/**
 *
 * @author Igor
 */
public interface BookService<T> {

    List<T> findByUserId(long userId);

    void create(T book);

    void update(T book);

    void delete(T book);

    List<T> findAll();
}
