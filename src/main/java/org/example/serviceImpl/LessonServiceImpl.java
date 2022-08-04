package org.example.serviceImpl;

import org.example.entity.Lesson;
import org.example.methodsImpl.LessonMethodsImpl;
import org.example.service.LessonService;

import java.util.List;

public class LessonServiceImpl  implements LessonService {
    LessonMethodsImpl lessonMethods=new LessonMethodsImpl();
    @Override
    public void saveLesson(Long id, Lesson lesson) {
        lessonMethods.saveLesson(id,lesson);

    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {

        lessonMethods.updateLesson(id,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonMethods.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        return lessonMethods.getLessonByCourseId(id);
    }

}
