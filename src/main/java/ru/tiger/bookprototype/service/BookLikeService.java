package ru.tiger.bookprototype.service;

/**
 *
 * @author Igor
 */
public interface BookLikeService {

    void like(long userId, long articleId);

    void unsetLike(long userId, long articleId);

    void dislike(long userId, long articleId);

    void unsetDislike(long userId, long articleId);
}
