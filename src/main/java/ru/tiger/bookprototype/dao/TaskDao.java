package ru.tiger.bookprototype.dao;

import javax.ejb.Stateless;
import ru.tiger.bookprototype.entity.Task;

/**
 *
 * @author Igor
 */
@Stateless
public class TaskDao extends AbstractDao<Task> {

    public TaskDao() {
        super(Task.class);
    }    
}
