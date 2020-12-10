package ru.tiger.bookprototype.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tiger.bookprototype.dao.BookDao;
import ru.tiger.bookprototype.entity.Book;
import ru.tiger.bookprototype.service.BookService;

/**
 *
 * @author Igor
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findByUserId(long userId) {
        return bookDao.findByUserId(userId);
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
