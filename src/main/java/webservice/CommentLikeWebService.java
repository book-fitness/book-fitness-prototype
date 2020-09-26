package webservice;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.service.CommentLikeService;
import webSecurity.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/commentLikeWebService")
public class CommentLikeWebService {

    @Context
    private UserSecurityContext userContext;

    @EJB
    private CommentLikeService commentLikeService;

    @POST
    @Path("/setLike/{commentLikeId}")
    public Response setLike(@PathParam("commentLikeId") Long commentLikeId) {
        Long userId = userContext.getUser().getId();

        try {
            commentLikeService.like(userId, commentLikeId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetLike/{articleId}")
    public Response unsetLike(@PathParam("articleId") long commentLikeId) {
        Long userId = userContext.getUser().getId();
        try {
            commentLikeService.like(userId, commentLikeId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/setDislike/{articleId}")
    public Response setDislike(@PathParam("articleId") long commentLikeId) {
        Long userId = userContext.getUser().getId();
        try {
            commentLikeService.dislike(userId, commentLikeId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetDislike/{articleId}")
    public Response unsetDislike(@PathParam("articleId") long commentLikeId) {
        Long userId = userContext.getUser().getId();
        try {
            commentLikeService.unsetDislike(userId, commentLikeId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
