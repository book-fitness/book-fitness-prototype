package ru.tiger.bookprototype.service;

import java.util.List;
import ru.tiger.bookprototype.entity.Task;

/**
 *
 * @author Igor
 */
public interface TaskService {
    List<Task> findUserTasks(long userId);

    Task findById(Long id);
    
    void create(Task task);

    void update(Task task);

    void delete(Task task);
}
