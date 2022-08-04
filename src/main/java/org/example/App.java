package org.example;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.serviceImpl.CourseServiceImpl;
import org.example.serviceImpl.InstructorServiceImpl;
import org.example.serviceImpl.LessonServiceImpl;
import org.example.serviceImpl.TaskServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);


        CourseServiceImpl courseService =new  CourseServiceImpl();
        InstructorServiceImpl instService = new InstructorServiceImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        TaskServiceImpl taskService = new TaskServiceImpl();
        Course course=new Course("C++", (byte) 8,LocalDate.of(2021,4,23),"jhgjgjgjgjghj","game");
        Course course1=new Course("Python",(byte) 4,LocalDate.of(2019,6,12),"hfsjdhfdjhf","backend");
        Course course2=new Course("DB",(byte)2,LocalDate.of(2022,9,21),"hdjfhdfhd","DataBase");


        Instructor instructor = new Instructor("Zamir","Sabyrjanov","zamir.sabyrjanov@gmail.com","+996778969543");
        Instructor instructor1 = new Instructor("Aijamal","Asangazieva","aijamal.as@gmail.com","+996551234567");
        Instructor instructor2 = new Instructor("Kanat","Myrzaev","myrza.kanat@gmail.com","+996708342167");

        Lesson lesson = new Lesson("PostgreSQL","hfhfghcg");
        Lesson lesson1 = new Lesson("JDBC","hkhgkygdnf");
        Lesson lesson2 = new Lesson("Git","shfdsufhksdfhz");



        Task task = new Task("HomeTask1",LocalDate.of(2022,7,20),"Git,GitHub,GitBush");
        Task task1= new Task("HomeTask2",LocalDate.of(2022,7,12),"PostgreSQL reshit zadachi");
        Task task2 = new Task("HomeTask3",LocalDate.of(2022,7,16),"JDBC,Hibernate");

        System.out.println(
                "1)Save Course \n" +
                "2)Get Course ById \n" +
                "3)Get all Course \n " +
                "4)Update Course \n " +
                "5)Delete Course by id \n" +
                "6)Get Course by name \n" +
                "7)Save Instructor \n" +
                "8)Update Instructor \n" +
                "9)Get Instructor by id\n" +
                "10)Get Instructor by Course id\n" +
                "11)Delete Instructor by id\n" +
                "12)Assign Instructor to Curse \n" +
                "13)Save Lesson\n" +
                "14)Update Lesson\n" +
                "15)Get Lesson by id\n" +
                "16)Get Lesson by Course id\n" +
                "17)Save Task\n" +
                "18)Update Task\n" +
                "19)Get Task by Lesson id\n" +
                "20)Delete Task by id ");
        while (true){
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    courseService.saveCourse(course);
                    courseService.saveCourse(course1);
                    ///courseService.saveCourse(course2);
                    break;
                case 2:
                    System.out.println(courseService.getCourseById(2L));
                    break;
                case 3:
                    courseService.getAllCourse().forEach(System.out::println);
                    break;
                case 4:
                    courseService.updateCourse(2L,course2);
                    break;
                case 5:
                    //courseService.deleteCourseById(1L);
                    courseService.deleteCourseById(2L);
                    break;
                case 6:
                    System.out.println(courseService.getCourseByName("Java Script"));
                    break;
                case 7:
                    instService.saveInstructor(instructor);
                    instService.saveInstructor(instructor1);
                    break;
                case 8:
                    instService.updateInstructor(4L,instructor2);
                    break;
                case 9:
                    System.out.println(instService.getInstructorById(4L));
                    break;
                case 10:
                    instService.getInstructorByCourseId(2L).forEach(System.out::println);
                    break;
                case 11:
                    instService.deleteInstructorById(5L);
                    break;
                case 12:
                    instService.assignInstructorToCourse(5L,2L);
                    instService.assignInstructorToCourse(5L,2L);
                    break;
                case 13:
                    lessonService.saveLesson(2L,lesson);
                    lessonService.saveLesson(3L,lesson1);
                    break;
                case 14:
                    lessonService.updateLesson(7L,lesson2);
                    break;
                case 15:
                    System.out.println(lessonService.getLessonById(6L));
                    break;
                case 16:
                    lessonService.getLessonByCourseId(3L).forEach(System.out::println);
                    break;
                case 17:
                    taskService.saveTask(6L,task);
                    taskService.saveTask(7L,task1);
                    break;
                case 18:
                    taskService.update(10L,task2);
                    break;
                case 19:
                    System.out.println(taskService.getTaskByLessonId(7L));
                    break;
                case 20:
                    taskService.deleteTaskById(9L);
                    break;

            }
        }



    }
}
