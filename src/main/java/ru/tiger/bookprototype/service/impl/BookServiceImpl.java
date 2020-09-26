package ru.tiger.bookprototype.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.dao.BookDao;
import ru.tiger.bookprototype.entity.Book;
import ru.tiger.bookprototype.service.BookService;

/**
 *
 * @author Igor
 */
@Stateless
public class BookServiceImpl implements BookService {

    @EJB
    private BookDao bookDao;

    @Override
    public List<Book> findByUserId(long userId) {
        return (List<Book>) bookDao.findById(userId);
    }

    @Override
    public void create(Book book) {
        bookDao.saveOrUpdate(book);
    }

    @Override
    public void update(Book book) {
        bookDao.saveOrUpdate(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.remove(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id);
    }
}
