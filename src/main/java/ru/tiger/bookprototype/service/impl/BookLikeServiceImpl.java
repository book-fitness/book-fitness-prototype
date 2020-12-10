package ru.tiger.bookprototype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.dao.BookLikeDao;
import ru.tiger.bookprototype.entity.BookLike;
import ru.tiger.bookprototype.service.BookLikeService;

/**
 *
 * @author Igor
 */
@Service
public class BookLikeServiceImpl implements BookLikeService {

    @Autowired
    private BookLikeDao bookLikeDao;

    private void setLikeOrDislike(long userId, long bookId, boolean value) {
        BookLike bookLike = bookLikeDao.findById(userId, bookId);
        if (bookLike == null) {
            bookLikeDao.create(new BookLike(userId, bookId, value));
        } else {
            bookLike.setValue(value);
            bookLikeDao.update(bookLike);
        }
    }

    private void unsetLikeOrDislike(long userId, long bookId) {
        BookLike bookLike = bookLikeDao.findById(userId, bookId);
        if (bookLike == null) {
            System.out.println("Was not found");
        } else {
            bookLikeDao.remove(bookLike);
        }
    }

    @Override
    public void like(long userId, long bookId) {
        setLikeOrDislike(userId, bookId, true);
    }

    @Override
    public void dislike(long userId, long bookId) {
        setLikeOrDislike(userId, bookId, false);
    }

    @Override
    public void unsetLike(long userId, long articleId) {
        unsetLikeOrDislike(userId, userId);
    }

    @Override
    public void unsetDislike(long userId, long articleId) {
        unsetDislike(userId, articleId);
    }
}
