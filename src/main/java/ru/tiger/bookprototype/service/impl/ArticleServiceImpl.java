package ru.tiger.bookprototype.service.impl;

import java.util.List;
import java.util.logging.Logger;
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
public class ArticleServiceImpl implements ArticleService {

    private static final Logger log = Logger.getGlobal();
    
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
        log.info("Article id " + article.getId() + " created.");
    }

    @Override
    public void update(Article article) {
        articleDao.saveOrUpdate(article);
        log.info("Article id " + article.getId() + " updated.");
    }

    @Override
    public void delete(Article article) {
        articleDao.remove(article);
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Override
    public Article findById(Long id) {
        return articleDao.findById(id);
    }
}