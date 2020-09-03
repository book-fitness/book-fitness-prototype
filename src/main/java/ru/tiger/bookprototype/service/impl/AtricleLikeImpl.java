package ru.tiger.bookprototype.service.impl;

import javax.ejb.EJB;
import ru.tiger.bookprototype.dao.ArticleLikeDao;
import ru.tiger.bookprototype.entity.ArticleLike;
import ru.tiger.bookprototype.service.ArticleLikeService;

/**
 *
 * @author Igor
 */
public class AtricleLikeImpl implements ArticleLikeService {

    @EJB
    ArticleLikeDao articleLikeDao;

    private void setLikeOrDislike(Long userId, Long articleId, boolean value) {

        ArticleLike articleLike = articleLikeDao.findById(userId, articleId);
        if (articleLike == null) {
            articleLikeDao.create(new ArticleLike(userId, articleId, value));
        } else {
            articleLike.setValue(value);
            articleLikeDao.update(articleLike);
        }
    }

    private void unsetLikeOrDislike(long userId, long articleId) {
        ArticleLike articleLike = articleLikeDao.findById(userId, articleId);
        if (articleLike == null) {
            System.out.println("Was not found");
        } else {
            articleLikeDao.remove(articleLike);
        }
    }

    @Override
    public void like(long userId, long articleId) {
        setLikeOrDislike(userId, articleId, true);
    }

    @Override
    public void dislike(long userId, long articleId) {
        setLikeOrDislike(userId, articleId, false);
    }

    @Override
    public void unsetLike(long userId, long articleId) {
        unsetLikeOrDislike(userId, articleId);
    }

    @Override
    public void unsetDislike(long userId, long articleId) {
        unsetLikeOrDislike(userId, articleId);
    }
}
