package com.example.task_1.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Author {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private LocalDate birthdate;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Course> courses;
}
