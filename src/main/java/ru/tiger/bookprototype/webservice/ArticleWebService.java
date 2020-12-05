package ru.tiger.bookprototype.webservice;

import java.util.Date;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.entity.Article;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.ArticleService;

/**
 *
 * @author Igor
 */
@Path("/article")
public class ArticleWebService {

    private static final Logger log = Logger.getGlobal();

    @Inject
    private SessionContext sessionContext;
    
    @EJB
    private ArticleService articleService;

    @GET
    @Path("{articleId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("articleId") Long id) {
        try {
            Article article = articleService.findById(id);
            article.setAuthor(null);
            return Response.ok(article).build();
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateArticleRequest request) {
        try {
            if (!sessionContext.hasLoggedIn()) {
                //throw new NotLoggedInException();
            }
            
            User user = sessionContext.getUser();
            Article article = new Article();
            article.setHeader(request.getHeader());
            article.setContent(request.getContent());
            article.setPublicationDate(new Date());
            article.setAuthor(user);
            //article.setUserId(user.getId());
            articleService.create(article);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            //log.throwing("", arg1, e);
            //log.error("Error when try create Article, userId" + user.getId(), e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(UpdateArticleRequest request) {
        try {
            Article article = articleService.findById(request.getId());
            article.setContent(request.getContent());
            article.setHeader(request.getHeader());
            articleService.update(article);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(@PathParam("articleId") Long articleId) {
        Article article = articleService.findById(articleId);
        try {
            articleService.delete(article);
            return Response.ok().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }
}
