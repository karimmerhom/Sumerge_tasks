package com.example.task_1.Controllers;

import com.example.task_1.Dtos.CourseCreateDto;
import com.example.task_1.Dtos.CourseDto;
import com.example.task_1.Models.Course;
import com.example.task_1.Mappers.CourseMapper;
import com.example.task_1.Services.CourseService;
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
@RequestMapping("/api/courses")
@Tag(name = "Course Controller", description = "Manage course operations")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping
    @Operation(summary = "Add a new course")
    public ResponseEntity<Void> addCourse(@Valid @RequestBody CourseCreateDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        courseService.addCourse(course);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a course")
    public ResponseEntity<Void> updateCourse(@PathVariable Integer id, @Valid @RequestBody CourseDto courseDto) {
        courseDto.setId(Long.valueOf(id));
        courseService.updateCourse(courseMapper.toEntityWithId(courseDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get course by ID")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Integer id) {
        Course course = courseService.getCourse(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseMapper.toDto(course));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a course by ID")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Get all courses (paginated)")
    public ResponseEntity<List<CourseDto>> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Course> coursePage = courseService.getAllCoursesPaged(page, size);
        List<CourseDto> courseDtos = coursePage.getContent()
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(courseDtos);
    }

    @GetMapping("/recommended")
    @Operation(summary = "Get recommended course names")
    public ResponseEntity<List<String>> getRecommendedCourses() {
        return ResponseEntity.ok(courseService.getRecommendedCourses());
    }
}
