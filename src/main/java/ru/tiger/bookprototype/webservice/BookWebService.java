package ru.tiger.bookprototype.webservice;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import ru.tiger.bookprototype.dao.UserDao;
import ru.tiger.bookprototype.entity.Book;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.security.web.DevServe;
import ru.tiger.bookprototype.security.web.Secured;
import ru.tiger.bookprototype.security.web.UserPrincipal;
import ru.tiger.bookprototype.service.BookService;

/**
 *
 * @author Igor
 */
@Secured
@DevServe
@Path("/book")
public class BookWebService {

    @Inject
    private SessionContext sessionContext;

    @Context
    private SecurityContext securityContext;

    @EJB
    private UserDao userDao;

    @EJB
    private BookService bookService;

    @GET
    @Path("{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("bookId") Long bookId) {
        try {
            return Response.ok(bookService.findById(bookId)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/getUserBooks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooksByUserId() {
        try {

            System.out.println("/getUserBooks " + securityContext);
            User user = ((UserPrincipal) securityContext.getUserPrincipal()).getUser();
            System.out.println("/getUserBooks for " + (user == null ? null : user.getUsername()));
            return Response.ok(bookService.findByUserId(user.getId())).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/getAllBooks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        try {
            List<Book> list = bookService.findByUserId(TemporaryUser.getId());
            //Long userId = sessionContext.getUser().getId();
            return Response.ok(list).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response create(CreateBookRequest request) {
        User user = ((UserPrincipal) securityContext.getUserPrincipal()).getUser();
        Book book = new Book();
        book.setName(request.getName());
        book.setCoverPath(request.getCoverPath());
        book.setUserId(user.getId());
        try {
            bookService.create(book);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(UpdateBookRequest request) {
        //User user = sessionContext.getUser();
        Book book = bookService.findById(request.getId());
        book.setName(request.getName());
        book.setCoverPath(request.getCoverPath());
        book.setUserId(TemporaryUser.getId());
        try {
            bookService.update(book);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("{bookId}")
    public Response delete(@PathParam("bookId") Long bookId) {
        Book book = bookService.findById(bookId);
        try {
            bookService.delete(book);
            return Response.ok().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @OPTIONS
    @Path("/getUserBooks")
    public Response overviewPreflight() {
        return Response.ok().build();
    }

    @OPTIONS
    @Path("/create")
    public Response overviewPreflight1() {
        return Response.ok().build();
    }
}
