package ru.tiger.bookprototype.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tiger.bookprototype.dao.TaskDao;
import ru.tiger.bookprototype.entity.Task;
import ru.tiger.bookprototype.service.TaskService;

/**
 *
 * @author Igor
 */
@Stateless
public class TaskServiceImpl implements TaskService {
    
    @EJB
    private TaskDao taskDao;

    @Override
    public List<Task> findUserTasks(long userId) {
        return taskDao.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskDao.findById(id);
    }

    @Override
    public void create(Task task) {
        taskDao.saveOrUpdate(task);
    }

    @Override
    public void update(Task task) {
        taskDao.saveOrUpdate(task);
    }

    @Override
    public void delete(Task task) {
        taskDao.remove(task);
    }   
}
