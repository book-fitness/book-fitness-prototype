package webservice;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.service.ArticleLikeService;
import webSecurity.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/articleLikeWebService")
public class ArticleLikeWebService {

    @Context
    private UserSecurityContext userContext;

    @EJB
    private ArticleLikeService articleLikeService;

    @POST
    @Path("/setLike/{articleId}")
    public Response setLike(@PathParam("articleId") long articleId) {
        Long userId = userContext.getUser().getId();

        try {
            articleLikeService.like(userId, articleId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetLike/{articleId}")
    public Response unsetLike(@PathParam("articleId") long articleId) {
        Long userId = userContext.getUser().getId();
        try {
            articleLikeService.unsetLike(userId, articleId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
