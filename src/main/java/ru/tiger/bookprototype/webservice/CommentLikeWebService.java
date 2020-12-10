package ru.tiger.bookprototype.webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tiger.bookprototype.service.CommentLikeService;
import ru.tiger.bookprototype.security.web.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/commentLike")
public class CommentLikeWebService {
    
    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");

    @Context
    private UserSecurityContext userContext;

    @Autowired
    private CommentLikeService commentLikeService;

    @POST
    @Path("/setLike/{commentLikeId}")
    public Response setLike(@PathParam("commentLikeId") Long commentLikeId) {
        Long userId = userContext.getUser().getId();

        try {
            commentLikeService.like(userId, commentLikeId);
            log.info("Comment like was set for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try setting comment like, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetLike/{articleId}")
    public Response unsetLike(@PathParam("articleId") long commentLikeId) {
        Long userId = userContext.getUser().getId();
        try {
            commentLikeService.like(userId, commentLikeId);
            log.info("Comment like was unset for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try unsetting comment like, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/setDislike/{articleId}")
    public Response setDislike(@PathParam("articleId") long commentLikeId) {
        Long userId = userContext.getUser().getId();
        try {
            commentLikeService.dislike(userId, commentLikeId);
            log.info("Comment dislike was set for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try setting comment dislike, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetDislike/{articleId}")
    public Response unsetDislike(@PathParam("articleId") long commentLikeId) {
        Long userId = userContext.getUser().getId();
        try {
            commentLikeService.unsetDislike(userId, commentLikeId);
            log.info("Comment dislike was unset for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try unsetting comment dislike, userId " + userId, e);
            return Response.serverError().build();
        }
    }
}
