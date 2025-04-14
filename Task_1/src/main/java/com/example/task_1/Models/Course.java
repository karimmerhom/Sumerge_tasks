package com.example.task_1.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Course {
    private int id;
    private String name;
    private String description;
    private int credit;

}
