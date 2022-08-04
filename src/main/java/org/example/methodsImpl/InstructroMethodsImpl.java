package org.example.methodsImpl;

import org.example.DB;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.methods.Instructro_method;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructroMethodsImpl implements Instructro_method {
    @Override
    public void saveInstructor(Instructor instructor) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(instructor.getFirstName() + "  successfully saved! ");

    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Id number "+id+" successfully updated ");
    }

    @Override
    public Instructor getInstructorById(Long id) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        List<Instructor> instructors = course.getInstructor();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("All instructors:  ");
        return instructors;

    }

    @Override
    public void deleteInstructorById(Long id) {
        try {
            EntityManager entityManager = DB.entityManager();
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, id);
            for (Course c : instructor.getCourse()) {
                c.setInstructor(null);
            }
            entityManager.remove(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("id " + id + " successfully deleted! ");
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void assignInstructorToCourse(Long id, Long courseId) {
        EntityManager entityManager = DB.entityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        Instructor instructor = entityManager.find(Instructor.class, id);
        course.addInstructor(instructor);
        instructor.addCourse(course);
        entityManager.persist(course);
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
