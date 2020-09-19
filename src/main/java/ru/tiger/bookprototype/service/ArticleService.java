package ru.tiger.bookprototype.service;

import java.util.List;
import ru.tiger.bookprototype.entity.Article;

/**
 *
 * @author Igor
 */
public interface ArticleService {
    
    List<Article> findByUserId(long userId);

    void create(Article article);

    void update(Article article);

    void delete(Article article);
    
    List<Article> findAll();

    public Article findById(Long id);
}
