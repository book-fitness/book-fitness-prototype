package webservice;

import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.entity.Article;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.ArticleService;
import webSecurity.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/articleWebService")
public class ArticleWebService {

    @Context
    private UserSecurityContext securityContext;

    @EJB
    private ArticleService articleService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response create(CreateArticleRequest request) {
        try {
            User user = securityContext.getUser();
            Article article = new Article();
            article.setHeader(request.getHeader());
            article.setContent(request.getContent());
            article.setPublicationDate(new Date());
            article.setAuthor(user);
            articleService.create(article);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
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
            article.setHeader(request.getHeaders());
            articleService.update(article);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/delete/{articleId}")
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
