package org.example.methods;

import org.example.entity.Course;

import java.util.List;

public interface Course_method {
    void saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    void updateCourse(Long id, Course course);

    void deleteCourseById(Long id);

    Course getCourseByName(String courseName);
}
