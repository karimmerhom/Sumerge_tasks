package com.example.task_1.Mappers;

import com.example.task_1.Dtos.CourseDto;
import com.example.task_1.Models.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(Course course);
    Course toEntity(CourseDto dto);
}