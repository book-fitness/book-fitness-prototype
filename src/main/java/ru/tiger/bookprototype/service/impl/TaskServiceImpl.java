package ru.tiger.bookprototype.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.dao.TaskDao;
import ru.tiger.bookprototype.entity.Task;
import ru.tiger.bookprototype.service.TaskService;

/**
 *
 * @author Igor
 */
@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
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
