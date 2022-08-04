package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
@Getter
@Setter

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //, generator = "player_generator")
    // @SequenceGenerator(name="player_generator", sequenceName = "player_seq", allocationSize = 1, initialValue = 1)

    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")

    private String phoneNumber;

    public Instructor( String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {
    }
    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH},fetch = FetchType.EAGER)
    private List<Course> course;

    public void addCourse(Course course1){
        this.course.add(course1);
        // course1.getInstructor().add(this);
    }

    public void removeCourse(Course course1){
        this.course.remove(course1);
        // course1.getInstructor().remove(this);
    }

    //    public void setCourse(Course course1) {
//        if (course==null) {
//            course = new ArrayList<>();
//        }
//            course1.setInstructor(this);
//    }
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
