package ru.tiger.bookprototype.webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tiger.bookprototype.service.BookLikeService;
import ru.tiger.bookprototype.security.web.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/bookLike")
public class BookLikeWebService {

    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");

    @Context
    private UserSecurityContext userContext;

    @Autowired
    private BookLikeService bookLikeService;

    @POST
    @Path("/setLike/{bookId}")
    public Response setLike(@PathParam("bookId") Long bookId) {
        Long userId = userContext.getUser().getId();
        try {
            bookLikeService.like(userId, bookId);
            log.info("Book like was set for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try setting book like, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetLike/{bookId}")
    public Response unsetLike(@PathParam("bookId") Long bookId) {
        Long userId = userContext.getUser().getId();
        try {
            bookLikeService.unsetLike(userId, bookId);
            log.info("Book like was unset for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try unsetting book like, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/setDislike/{bookId}")
    public Response setDisLike(@PathParam("bookId") Long bookId) {
        Long userId = userContext.getUser().getId();
        try {
            bookLikeService.dislike(userId, bookId);
            log.info("Book dislike was set for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try setting book dislike, userId " + userId, e);
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetDislike/{bookId}")
    public Response unsetDisLike(@PathParam("bookId") Long bookId) {
        Long userId = userContext.getUser().getId();
        try {
            bookLikeService.unsetDislike(userId, bookId);
            log.info("Book dislike was unset for userId " + userId);
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Error when try unsetting book dislike, userId " + userId, e);
            return Response.serverError().build();
        }
    }
}
