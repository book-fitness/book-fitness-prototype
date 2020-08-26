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

    void edit(Article article);

    void delete(Article article);
    
    List<Article> showAllArticles();
}
