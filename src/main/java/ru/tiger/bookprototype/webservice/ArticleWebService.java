package ru.tiger.bookprototype.webservice;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.Article;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.security.web.DevServe;
import ru.tiger.bookprototype.security.web.Secured;
import ru.tiger.bookprototype.security.web.UserPrincipal;
import ru.tiger.bookprototype.service.ArticleService;

/**
 *
 * @author Igor
 */
@DevServe
@Secured
@Path("/article")
public class ArticleWebService {

    private static final Logger log = Logger.getGlobal();

//    @Inject
//    private SecurityContext securityContext;
    @Inject
    private SessionContext sessionContext;
    
    @Context
    private SecurityContext securityContext;

    @EJB
    private UserDao userDao;

    @EJB
    private ArticleService articleService;

    @GET
    @Path("{articleId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("articleId") Long id) {
        try {
            Article article = articleService.findById(id);
            article.setId(null);
            return Response.ok(article).build();
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/getAllArticles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllArticles() {
        try {
            User user = ((UserPrincipal) securityContext.getUserPrincipal()).getUser();
            List<Article> article = articleService.findByUserId(user.getId());
            return Response.ok(article).build();
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response create(CreateArticleRequest request) {
        try {
            User user = ((UserPrincipal) securityContext.getUserPrincipal()).getUser();
            Article article = new Article();
            article.setHeader(request.getHeader());
            article.setContent(request.getContent());
            article.setPublicationDate(new Date());
            article.setUserId(user.getId());
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
    @Path("/update")
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
    @Path("/delete")
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
