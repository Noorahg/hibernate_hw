package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@Getter
@Setter

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen",sequenceName = "passport_gen",allocationSize = 1)
    private Long id;
    @Column(name="local_date",nullable=false)
    private String name;
    private byte duration;
    @Column(name="local_date",nullable = false)

    private LocalDate createAt;
    private String imageLink;
    private String description;

    public Course() {
    }

    public Course( String name, byte duration, LocalDate createAt, String imageLink, String description) {
        this.name = name;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,
            CascadeType.DETACH,CascadeType.PERSIST},mappedBy = "course",fetch = FetchType.EAGER)
    private List<Instructor>instructor;

    public void addInstructor(Instructor instructor1){
        this.instructor.add(instructor1);

    }


    public void  removeInstructor(Instructor instructor1){

        this.instructor.remove(instructor1);
    }

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,
            CascadeType.DETACH,CascadeType.REFRESH},mappedBy = "course",fetch = FetchType.LAZY)
    private List<Lesson>lesson;

    @Override
    public String toString() {
        return id+"  "+name+"  "+duration+"  "+createAt+ "  "+description+ " "+imageLink;
    }

    //    public void setInstructor(Instructor instructor0){
//        instructor.add(instructor0);
//    }
    public void setLesson(Lesson lesson1){

        lesson.add(lesson1);
    }
}
