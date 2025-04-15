package com.example.task_1.Models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int credit;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Assessment assessment;
}

