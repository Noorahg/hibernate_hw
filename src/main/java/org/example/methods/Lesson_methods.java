package org.example.methods;

import org.example.entity.Lesson;

import java.util.List;

public interface Lesson_methods {
    void saveLesson(Long id, Lesson lesson);

    void updateLesson(Long id, Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getLessonByCourseId(Long id);
}
