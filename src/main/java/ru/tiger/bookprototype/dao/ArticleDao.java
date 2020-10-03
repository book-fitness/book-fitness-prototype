package ru.tiger.bookprototype.dao;

import javax.ejb.Stateless;
import ru.tiger.bookprototype.entity.Article;

/**
 *
 * @author Igor
 */
@Stateless
public class ArticleDao extends AbstractDao<Article> {
    public ArticleDao() {
        super(Article.class);
    }
}
