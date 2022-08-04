package org.example.service;

import org.example.entity.Task;

import java.util.List;

public interface TaskService {
    void saveTask(Long id,Task task);

    void update(Long id, Task task);

    List<Task> getTaskByLessonId(Long id);

    void deleteTaskById(Long id);
}
