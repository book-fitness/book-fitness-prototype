package ru.tiger.bookprototype.service;

import java.util.List;
import ru.tiger.bookprototype.entity.UserLike;

/**
 *
 * @author Igor
 */
public interface UserLikeService {

    List<UserLike> findByUserId(long userId);

    void like(long userId, long articleId);

    void unsetLike(long userId, long articleId);

    void dislike(long userId, long articleId);

    void unsetDislike(long userId, long articleId);
}
