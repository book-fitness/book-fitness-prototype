package ru.tiger.bookprototype.webservice;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.service.ArticleLikeService;
import ru.tiger.bookprototype.security.web.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/articleLike")
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

    @POST
    @Path("/setDislike/{articleId}")
    public Response dislike(@PathParam("articleId") long articleId) {
        Long userId = userContext.getUser().getId();

        try {
            articleLikeService.dislike(userId, articleId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetDislike/{articleId}")
    public Response unsetDislike(@PathParam("articleId") long articleId) {
        Long userId = userContext.getUser().getId();

        try {
            articleLikeService.unsetDislike(userId, articleId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
