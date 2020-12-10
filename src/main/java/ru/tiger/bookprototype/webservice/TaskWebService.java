package ru.tiger.bookprototype.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tiger.bookprototype.entity.Task;
import ru.tiger.bookprototype.service.TaskService;

/**
 *
 * @author Igor
 */
@Path("/task")
public class TaskWebService {
    
    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");

    @Autowired
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
            log.info("Create task id " + task.getId());
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            log.error("Create task failed, id " + task.getId(), ex );
            return Response.serverError().build();
        }
    }
}
