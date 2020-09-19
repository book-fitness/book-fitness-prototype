package webservice;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.entity.Book;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.BookService;
import webSecurity.UserSecurityContext;

/**
 *
 * @author Igor
 */
@Path("/bookWebService")
public class BookWebService {

    @Context
    private UserSecurityContext securityContext;

    @EJB
    BookService bookService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateBookRequest request) {
        User user = securityContext.getUser();
        Book book = new Book();
        book.setName(request.getName());
        book.setCoverPath(request.getCoverPath());
        book.setPublisher(user);
        try {
            bookService.create(book);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(UpdateBookRequest request) {
        User user = securityContext.getUser();

        Book book = bookService.findById(request.getId());
        book.setName(request.getName());
        book.setCoverPath(request.getCoverPath());
        book.setPublisher(user);
        try {
            bookService.update(book);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/delete/{bookId}")
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
}
