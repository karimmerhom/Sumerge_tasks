package com.example.task_1.Models;

import jakarta.persistence.*;

@Entity
public class Assessment {
    @Id @GeneratedValue
    private Long id;

    private String content;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
