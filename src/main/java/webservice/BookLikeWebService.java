package webservice;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.service.BookLikeService;
import webSecurity.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/bookLikeWebService")
public class BookLikeWebService {

    @Context
    private UserSecurityContext userContext;

    @EJB
    private BookLikeService bookLikeService;

    @POST
    @Path("/setLike/{bookId}")
    public Response setLike(@PathParam("bookId") Long bookId) {
        Long userId = userContext.getUser().getId();
        try {
            bookLikeService.like(userId, bookId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetLike/{bookId}")
    public Response unsetLike(@PathParam("bookId") Long bookId) {
        Long userId = userContext.getUser().getId();
        try {
            bookLikeService.unsetLike(userId, bookId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/setDislike/{bookId}")
    public Response setDisLike(@PathParam("bookId") Long bookId) {
        Long userId = userContext.getUser().getId();
        try {
            bookLikeService.dislike(userId, bookId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/unsetDislike/{bookId}")
    public Response unsetDisLike(@PathParam("bookId") Long bookId) {
        Long userId = userContext.getUser().getId();
        try {
            bookLikeService.unsetDislike(userId, bookId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
