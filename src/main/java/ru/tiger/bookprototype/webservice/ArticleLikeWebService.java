package ru.tiger.bookprototype.webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tiger.bookprototype.security.web.DevServe;
import ru.tiger.bookprototype.security.web.Secured;
import ru.tiger.bookprototype.service.ArticleLikeService;
import ru.tiger.bookprototype.security.web.UserSecurityContext;

/**
 *
 * @author Igor
 */
@DevServe
@Secured
@Path("/articleLike")
public class ArticleLikeWebService {
    
    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");

    @Context
    private UserSecurityContext userContext;

    @Autowired
    private ArticleLikeService articleLikeService;

    @POST
    @Path("/setLike/{articleId}")
    public Response setLike(@PathParam("articleId") long articleId) {
        Long userId = userContext.getUser().getId();

        try {
            articleLikeService.like(userId, articleId);
            log.info("Article like was set for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try setting article like, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetLike/{articleId}")
    public Response unsetLike(@PathParam("articleId") long articleId) {
        Long userId = userContext.getUser().getId();
        try {
            articleLikeService.unsetLike(userId, articleId);
            log.info("Article like was unset for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try unsetting article like, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/setDislike/{articleId}")
    public Response dislike(@PathParam("articleId") long articleId) {
        Long userId = userContext.getUser().getId();

        try {
            articleLikeService.dislike(userId, articleId);
            log.info("Article dislike was set for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try setting article dislike, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetDislike/{articleId}")
    public Response unsetDislike(@PathParam("articleId") long articleId) {
        Long userId = userContext.getUser().getId();

        try {
            articleLikeService.unsetDislike(userId, articleId);
            log.info("Article dislike was unset for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try unsetting article dislike, userId " + userId, e);
            return Response.serverError().build();
        }
    }
}
