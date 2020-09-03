package ru.tiger.bookprototype.service.impl;

import java.util.List;
import javax.ejb.EJB;
import ru.tiger.bookprototype.dao.BookDao;
import ru.tiger.bookprototype.entity.Book;
import ru.tiger.bookprototype.service.BookService;

/**
 *
 * @author Igor
 */
public class BookServiceImpl implements BookService<Book> {
    
    @EJB
    private BookDao bookDao;

    @Override
    public List<Book> findByUserId(long userId) {
        return (List<Book>) bookDao.findById(userId);
    }

    @Override
    public void create(Book article) {
        bookDao.saveOrUpdate(article);
    }

    @Override
    public void update(Book article) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Book book) {
        bookDao.remove(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }
    
}
