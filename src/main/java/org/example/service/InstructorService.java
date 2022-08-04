package org.example.service;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorService {
    void saveInstructor(Instructor instructor);

    void updateInstructor(Long id, Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long id);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long id, Long courseId);

}
