package com.example.task_1.Dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthdate;
}