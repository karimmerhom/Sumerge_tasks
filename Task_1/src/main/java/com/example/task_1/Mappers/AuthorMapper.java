package com.example.task_1.Mappers;

import com.example.task_1.Dtos.AuthorCreateDto;
import com.example.task_1.Dtos.AuthorDto;
import com.example.task_1.Models.Author;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toDto(Author author);
    Author toEntityWithId(@Valid AuthorDto author);// for response
    Author toEntity(AuthorCreateDto createDto);

}

