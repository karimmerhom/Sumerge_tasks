package com.example.task_1.Dtos;

import lombok.Data;

@Data
public class CourseDto {
    private Long id;  // No need for @Id or @GeneratedValue
    private String name;
    private String description;
    private int credit;
    private Long authorId;

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", credit=" + credit +
                ", authorId=" + authorId +
                '}';
    }
}
