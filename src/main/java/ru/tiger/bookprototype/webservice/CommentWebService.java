package ru.tiger.bookprototype.webservice;

import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tiger.bookprototype.entity.Comment;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.security.web.DevServe;
import ru.tiger.bookprototype.security.web.Secured;
import ru.tiger.bookprototype.service.CommentService;
import ru.tiger.bookprototype.service.UserService;

/**
 *
 * @author Igor
 */
@DevServe
@Secured
@Path("/comment")
public class CommentWebService {

    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");

    @Context
    private HttpHeaders httpHeaders;
    
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GET
    @Path("{articleId}")
    public Response get(@PathParam("articleId") Long articleId) {
        try {
            log.info("Get comment by id " + articleId);
            return Response.ok(commentService.findByArticleId(articleId)).build();
        } catch (Exception ex) {
            log.error("Get comment by id failed " + articleId, ex);
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateCommentRequest request) {
        User user = userService.findByHeaders(httpHeaders);
        try {
            Comment comment = new Comment();
            comment.setAuthor(user);
            comment.setPublicationDate(new Date());
            comment.setText(request.getText());
            comment.setParentId(request.getParentId());
            comment.setArticleId(request.getArticleId());
            commentService.create(comment);
            log.info("Create comment by user " + user.getId());
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            log.error("Create comment by user failed " + user.getId(), ex);
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
            log.info("Update comment " + comment.getId());
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            log.error("Update comment failed " + comment.getId(), ex);
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(@PathParam("commentId") Long commentId) {
        Comment comment = commentService.findById(commentId);
        try {
            commentService.delete(comment);
            log.info("Delete comment " + comment.getId());
            return Response.ok().build();
        } catch (Exception ex) {
            log.error("Delete comment failed " + comment.getId(), ex);
            return Response.serverError().build();
        }
    }
}
