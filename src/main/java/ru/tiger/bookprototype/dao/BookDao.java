package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
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

