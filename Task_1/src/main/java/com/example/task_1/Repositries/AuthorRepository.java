package com.example.task_1.Repositries;

import com.example.task_1.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByEmailContainingIgnoreCase(String email);
}