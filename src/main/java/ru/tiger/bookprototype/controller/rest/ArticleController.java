package ru.tiger.bookprototype.controller.rest;
/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.tiger.bookprototype.entity.Article;
import ru.tiger.bookprototype.repository.ArticleRepository;

@RestController
//@RequestMapping("api/article")
public class ArticleController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    //private Map<Integer, Article> articles = new HashMap<>();
    //private int idCounter = 1;
    */
   // @RequestMapping(path = "/api/article", method = RequestMethod.POST/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
   /* public ResponseEntity add(@RequestBody Article article) {
        article = articleRepository.save(article);
        System.out.println("<< Add article: " + article);
        
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(path = "/api/article/{id}", method = RequestMethod.GET)
    public Article find(@PathVariable long id) {
        System.out.println("<< GET post");
        Article article = null;
        article = articleRepository.findOne(id);
        
        System.out.println("<< Find post: " + article);
        
        return article;
    }
    
    @RequestMapping(path = "/api/articles", method = RequestMethod.GET)
    public List<Article> findAll() {
        List<Article> articles = articleRepository.findAll();
        System.out.println("Find all articles: " + articles);
        return articles;
    }
    
    @RequestMapping(path = "api/article/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Article article) {
        articleRepository.save(article);
        System.out.println("<< Update article: " + article);
    }
    
    @RequestMapping(path = "api/article/{id}", method = RequestMethod.DELETE)
    public void removePost(@PathVariable long id) {
        articleRepository.delete(id);
        System.out.println("<< Detete article id: " + id);
    }
}
*/