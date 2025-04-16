package com.example.task_1.Services;

import com.example.task_1.Models.Author;
import com.example.task_1.Repositries.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }


    public List<Author> getAuthorsByEmail(String email) {
        return authorRepository.findByEmailContainingIgnoreCase(email);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
