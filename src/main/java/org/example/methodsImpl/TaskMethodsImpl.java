package org.example.methodsImpl;

import org.example.DB;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.methods.Task_method;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskMethodsImpl implements Task_method {
    @Override
    public void saveTask(Long id, Task task) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        lesson.addTask(task);
        task.setLesson(lesson);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(task.getLesson()+" successfully saved ");

    }

    @Override
    public void update(Long id, Task task) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class,id);
        task1.setTaskName(task.getTaskName());
        task1.setTask(task.getTask());
        task1.setDeadline(task.getDeadline());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Id: "+id +" successfully updated ");

    }

    @Override
    public List<Task> getTaskByLessonId(Long id) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Lesson lesson  = entityManager.find(Lesson.class,id);
        List<Task> tasks = lesson.getTask();
        entityManager.getTransaction().commit();
        entityManager.close();

        return tasks;
    }

    @Override
    public void deleteTaskById(Long id) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class,id);
        task.setLesson(null);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("id: "+id +" successfully deleted! ");
    }
}
