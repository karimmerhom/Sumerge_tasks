package com.example.task_1.Dtos;

import lombok.Data;

@Data
public class CourseCreateDto {
    private String name;
    private String description;
    private int credit;
    private int authorId;

    @Override
    public String toString() {
        return "CourseDto{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", credit=" + credit +
                ", authorId=" + authorId +
                '}';
    }
}
