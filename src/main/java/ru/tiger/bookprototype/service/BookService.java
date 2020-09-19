package ru.tiger.bookprototype.service;

import java.util.List;
import ru.tiger.bookprototype.entity.Book;

/**
 *
 * @author Igor
 */
public interface BookService {

    List<Book> findByUserId(long userId);

    Book findById(Long id);
    
    void create(Book book);

    void update(Book book);

    void delete(Book book);

    List<Book> findAll();
}
