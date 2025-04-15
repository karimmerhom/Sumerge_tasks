package com.example.task_1.Mappers;

import com.example.task_1.Dtos.AuthorDto;
import com.example.task_1.Models.Author;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toDto(Author author);
    Author toEntity(AuthorDto dto);
}

