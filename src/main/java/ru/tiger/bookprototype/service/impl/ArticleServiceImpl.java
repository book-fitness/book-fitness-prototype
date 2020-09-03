package ru.tiger.bookprototype.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.dao.ArticleDao;
import ru.tiger.bookprototype.entity.Article;
import ru.tiger.bookprototype.service.ArticleService;

/**
 *
 * @author Igor
 */
@Stateless
public class ArticleServiceImpl implements ArticleService<Article> {

    @EJB
    private ArticleDao articleDao;

    public ArticleServiceImpl() {
    }

    @Override
    public List<Article> findByUserId(long userId) {
        return (List<Article>) articleDao.findById(userId);
    }

    @Override
    public void create(Article article) {
        articleDao.saveOrUpdate(article);
    }

    @Override
    public void update(Article article) {
        
    }

    @Override
    public void delete(Article article) {
        articleDao.remove(article);
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }
}