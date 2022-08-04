package org.example.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name="task")
@Getter
@Setter

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    ///  , generator = "player_generator")
    //@SequenceGenerator(name="player_generator", sequenceName = "player_seq", allocationSize = 1, initialValue = 1)

    private Long id;
    private String taskName;
    private LocalDate deadline;
    @Column(length = 1000000)

    private String task;


    public Task( String taskName, LocalDate deadline, String task) {
        this.taskName= taskName;
        this.deadline = deadline;
        this.task = task;
    }

    public Task() {
    }




    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},fetch = FetchType.EAGER)
    private Lesson lesson;



    //    public void removeTask(Task task){
//        this.task.r
//    }
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task_name='" + taskName + '\'' +
                ", deadline=" + deadline +
                ", task='" + task + '\'' +
                '}';
    }
}

