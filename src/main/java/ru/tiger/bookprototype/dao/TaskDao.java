package ru.tiger.bookprototype.dao;

import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.entity.Task;

/**
 *
 * @author Igor
 */
@Service
public class TaskDao extends AbstractDao<Task> {

    public TaskDao() {
        super(Task.class);
    }    
}
