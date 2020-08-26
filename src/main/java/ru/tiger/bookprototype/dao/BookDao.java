package ru.tiger.bookprototype.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.entity.Book;

/**
 *
 * @author Igor
 */
@Stateless
@LocalBean
public class BookDao extends AbstractDao<Book> {

    public BookDao() {
        super(Book.class);
    }
}

