package org.example.serviceImpl;

import org.example.entity.Course;
import org.example.methodsImpl.CourseMethodsImpl;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl  implements CourseService {

    CourseMethodsImpl courseMethods=new CourseMethodsImpl();
    @Override
    public void saveCourse(Course course) {
        courseMethods.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {

        return courseMethods.getCourseById(id);

    }

    @Override
    public List<Course> getAllCourse() {
        return courseMethods.getAllCourse();
    }

    @Override
    public void updateCourse(Long id, Course course) {
        courseMethods.updateCourse(id,course);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseMethods.deleteCourseById(id);

    }

    @Override
    public Course getCourseByName(String Name) {
        return courseMethods.getCourseByName(Name);
    }
}
