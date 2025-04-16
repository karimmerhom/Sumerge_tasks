package com.example.task_1.Controllers;

import com.example.task_1.Dtos.AuthorCreateDto;
import com.example.task_1.Dtos.AuthorDto;
import com.example.task_1.Mappers.AuthorMapper;
import com.example.task_1.Models.Author;
import com.example.task_1.Services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Author Controller", description = "Manage author operations")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    @Operation(summary = "Add a new author")
    public ResponseEntity<Void> addAuthor(@Valid @RequestBody AuthorCreateDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorService.addAuthor(author);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an author")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorDto authorDto) {
        authorDto.setId(id);
        authorService.updateAuthor(authorMapper.toEntityWithId(authorDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get author by ID")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable Long id) {
        Author author = authorService.getAuthor(id);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authorMapper.toDto(author));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an author by ID")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Get all authors (with optional email filter)")
    public ResponseEntity<List<AuthorDto>> getAllAuthors(@RequestParam(required = false) String email) {
        List<Author> authors = (email != null)
                ? authorService.getAuthorsByEmail(email)
                : authorService.getAllAuthors();

        List<AuthorDto> authorDtos = authors.stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(authorDtos);

    }
}