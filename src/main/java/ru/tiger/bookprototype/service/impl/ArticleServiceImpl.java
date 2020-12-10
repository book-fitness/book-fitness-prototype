package ru.tiger.bookprototype.service.impl;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tiger.bookprototype.dao.ArticleDao;
import ru.tiger.bookprototype.entity.Article;
import ru.tiger.bookprototype.service.ArticleService;

/**
 *
 * @author Igor
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private static final Logger log = Logger.getGlobal();
    
    @Autowired
    private ArticleDao articleDao;

    public ArticleServiceImpl() {
    }

    @Override
    public List<Article> findByUserId(long userId) {
        return articleDao.findallArticlesByUserId(userId);
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
