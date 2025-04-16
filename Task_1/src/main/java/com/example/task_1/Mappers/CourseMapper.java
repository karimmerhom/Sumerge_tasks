package com.example.task_1.Mappers;

import com.example.task_1.Dtos.CourseCreateDto;
import com.example.task_1.Dtos.CourseDto;
import com.example.task_1.Models.Course;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "author.id", target = "authorId")
    CourseDto toDto(Course course);

    @Mapping(source = "authorId", target = "author.id")
    Course toEntityWithId(CourseDto dto);

    @Mapping(source = "authorId", target = "author.id")
    Course toEntity(CourseCreateDto dto);
}

