package ru.tiger.bookprototype.dao;

import javax.ejb.Stateless;
import ru.tiger.bookprototype.entity.Book;

/**
 *
 * @author Igor
 */
@Stateless
public class BookDao extends AbstractDao<Book> {
    public BookDao() {
        super(Book.class);
    }
}

