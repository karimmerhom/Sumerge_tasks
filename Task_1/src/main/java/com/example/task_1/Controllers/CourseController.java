package com.example.task_1.Controllers;

import com.example.task_1.Models.Course;
import com.example.task_1.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/discover")
    public List<String> discoverCourses() {
        return courseService.getRecommendedCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    public String addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return "Course added successfully!";
    }

    @PutMapping("/{id}")
    public String updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        courseService.updateCourse(course);
        return "Course updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return "Course deleted successfully!";
    }
}

