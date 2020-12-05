package ru.tiger.bookprototype.webservice;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.entity.Task;
import ru.tiger.bookprototype.service.TaskService;

/**
 *
 * @author Igor
 */
@Path("/task")
public class TaskWebService {

    @Inject
    private SessionContext sessionContext;

    @EJB
    private TaskService taskService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateTaskRequest taskRequest) {
        Task task = new Task();
        task.setTaskText(taskRequest.getTaskText());
        task.setTaskDetails(taskRequest.getTaskDetails());
        task.setUserId(TemporaryUser.getId());
        try {
            taskService.create(task);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }
}
