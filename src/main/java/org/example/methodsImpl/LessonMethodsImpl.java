package org.example.methodsImpl;

import org.example.DB;
import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.methods.Lesson_methods;

import javax.persistence.EntityManager;
import java.util.List;

public class LessonMethodsImpl implements Lesson_methods {
    @Override
    public void saveLesson(Long id, Lesson lesson) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        lesson.setCourse(course);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class,id);
        lesson1.setLessonName(lesson.getLessonName());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("id: "+ id + " successfully deleted! ");

    }

    @Override
    public Lesson getLessonById(Long id) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        List<Lesson> lesson = course.getLesson();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("All lessons: ");
        return lesson;
    }
}
