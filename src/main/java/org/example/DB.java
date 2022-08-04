package org.example;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import java.util.Properties;



public class DB {

    public static SessionFactory getSession() {
        Configuration configuration = new Configuration();
        Properties prop = new Properties();
        prop.setProperty("connection.driver_class", "com.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/postgres");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "gulnur");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        prop.setProperty("hibernate.current_session_context_class", "thread");
        configuration.setProperties(prop);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Task.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
    public static EntityManager entityManager(){
        return getSession().createEntityManager();

    }
}
