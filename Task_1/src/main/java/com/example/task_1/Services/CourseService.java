package com.example.task_1.Services;

import com.example.task_1.Models.Course;
import com.example.task_1.Repositries.CourseRepository;
import com.example.task_1_new_bean.Interfaces.CourseRecommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRecommender courseRecommender;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(
            @Qualifier("explicitReactCourseRecommender") CourseRecommender courseRecommender,
            CourseRepository courseRepository) {
        this.courseRecommender = courseRecommender;
        this.courseRepository = courseRepository;
    }

    // Keep this method as is
    public List<String> getRecommendedCourses() {
        return courseRecommender.recommendedCourses();
    }

    public void addCourse(Course c) {
        courseRepository.save(c);
    }

    public void updateCourse(Course c) {
        courseRepository.save(c);
    }

    public Course getCourse(int id) {
        return courseRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById((long) id);
    }

    public Page<Course> getAllCoursesPaged(int page, int size) {
        return courseRepository.findAll(PageRequest.of(page, size));
    }
}
