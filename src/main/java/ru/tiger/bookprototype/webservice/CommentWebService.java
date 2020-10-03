package ru.tiger.bookprototype.webservice;

import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.entity.Comment;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.CommentService;
import ru.tiger.bookprototype.security.web.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/comment")
public class CommentWebService {

    @Context
    private UserSecurityContext securityContext;

    @EJB
    private CommentService commentService;

    @GET
    @Path("{articleId}")
    public Response get(@PathParam("articleId") Long articleId) {
        try {
            return Response.ok(commentService.findByArticleId(articleId)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateCommentRequest request) {
        try {
            User user = securityContext.getUser();
            Comment comment = new Comment();
            comment.setAuthor(user);
            comment.setPublicationDate(new Date());
            comment.setText(request.getText());
            comment.setParentId(request.getParentId());
            comment.setArticleId(request.getArticleId());
            commentService.create(comment);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(UpdateCommentRequest request) {
        Comment comment = commentService.findById(request.getId());
        try {
            comment.setText(request.getText());
            commentService.update(comment);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(@PathParam("commentId") Long commentId) {
        Comment comment = commentService.findById(commentId);
        try {
            commentService.delete(comment);
            return Response.ok().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }
}
