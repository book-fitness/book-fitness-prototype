package ru.tiger.bookprototype.webservice;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import ru.tiger.bookprototype.entity.Article;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.security.web.DevServe;
import ru.tiger.bookprototype.security.web.Secured;
import ru.tiger.bookprototype.service.ArticleService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tiger.bookprototype.service.UserService;

/**
 *
 * @author Igor
 */
@DevServe
@Secured
@Path("/article")
public class ArticleWebService {

    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");

    @Context
    private HttpHeaders httpHeaders;

    @Autowired
    private UserService userService;
    
    @Autowired
    private ArticleService articleService;

    @GET
    @Path("{articleId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("articleId") Long id) {
        try {
            Article article = articleService.findById(id);
            article.setId(null);
            log.info("Get article by id " + id);
            return Response.ok(article).build();
        } catch (Exception ex) {
            log.info("Get article by id failed" + id, ex);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/getAllArticles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllArticles() {
        User user = userService.findByHeaders(httpHeaders);
        try {
            List<Article> article = articleService.findByUserId(user.getId());
            log.info("Get all articles for user, id " + user.getId());
            return Response.ok(article).build();
        } catch (Exception ex) {
            log.error("Get all articles for user failed, id " + user.getId(), ex);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response create(CreateArticleRequest request) {
        User user = userService.findByHeaders(httpHeaders);
        try {
            Article article = new Article();
            article.setHeader(request.getHeader());
            article.setContent(request.getContent());
            article.setPublicationDate(new Date());
            article.setUserId(user.getId());
            articleService.create(article);
            log.info("Article is created, id " + article.getId());
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            log.error("Error when try create Article, userId " + user.getId(), e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response update(UpdateArticleRequest request) {
        try {
            Article article = articleService.findById(request.getId());
            article.setContent(request.getContent());
            article.setHeader(request.getHeader());
            articleService.update(article);
            log.info("Update article, id " + request.getId());
            return Response.ok().build();
        } catch (Exception e) {
            log.info("Update article failed, id " + request.getId());
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/delete")
    public Response delete(@PathParam("articleId") Long articleId) {
        Article article = articleService.findById(articleId);
        try {
            articleService.delete(article);
            log.info("Delete article, id " + articleId);
            return Response.ok().build();
        } catch (Exception ex) {
            log.info("Delete article failed, id " + articleId);
            return Response.serverError().build();
        }
    }

    @OPTIONS
    @Path("/create")
    public Response overviewPreflightCreate() {
        return Response.ok().build();
    }

    @OPTIONS
    @Path("/update")
    public Response overviewPreflightUpdate() {
        return Response.ok().build();
    }

    @OPTIONS
    @Path("/delete")
    public Response overviewPreflightDelete() {
        return Response.ok().build();
    }

    @OPTIONS
    @Path("/getAllArticles")
    public Response overviewPreflightgetAllArticles() {
        return Response.ok().build();
    }
}
