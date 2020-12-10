package ru.tiger.bookprototype.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.entity.Article;

/**
 *
 * @author Igor
 */
@Service
public class ArticleDao extends AbstractDao<Article> {
    public ArticleDao() {
        super(Article.class);
    }
    
    public List<Article> findallArticlesByUserId(Long id) {
        TypedQuery<Article> typedQuery = entityManager.createQuery("SELECT a FROM Article a WHERE a.userId = :id" ,Article.class);
        typedQuery.setParameter("id", id);
        List<Article> list =  typedQuery.getResultList();
        return list;
    }
}
