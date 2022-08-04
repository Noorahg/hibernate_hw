package org.example.serviceImpl;

import org.example.entity.Instructor;
import org.example.methodsImpl.InstructroMethodsImpl;
import org.example.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl  implements InstructorService {
    InstructroMethodsImpl instructroMethods=new InstructroMethodsImpl();
    @Override
    public void saveInstructor(Instructor instructor) {

        instructroMethods.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructroMethods.updateInstructor(id,instructor);

    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructroMethods.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return instructroMethods.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructroMethods.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long id, Long courseId) {
        instructroMethods.assignInstructorToCourse(id,courseId);
    }
}
