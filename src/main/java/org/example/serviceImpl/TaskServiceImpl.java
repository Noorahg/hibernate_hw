package org.example.serviceImpl;

import org.example.entity.Task;
import org.example.methodsImpl.TaskMethodsImpl;
import org.example.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    TaskMethodsImpl taskMethods=new TaskMethodsImpl();
    @Override
    public void saveTask(Long id, Task task) {
        taskMethods.saveTask(id, task);

    }



    @Override
    public void update(Long id, Task task) {
        taskMethods.update(id,task);
    }

    @Override
    public List<Task> getTaskByLessonId(Long id) {
        return taskMethods.getTaskByLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskMethods.deleteTaskById(id);
    }
}
