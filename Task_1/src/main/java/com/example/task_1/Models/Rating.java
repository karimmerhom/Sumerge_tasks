package com.example.task_1.Models;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id @GeneratedValue
    private Long id;

    private int number;

    @ManyToOne
    private Course course;
}
