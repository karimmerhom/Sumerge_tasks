package com.example.task_1.Services;

import com.example.task_1.Models.Course;
import com.example.task_1.Repositries.CourseRepository;
import com.example.task_1_new_bean.Interfaces.CourseRecommender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseServiceTest {

    @Mock
    private CourseRecommender courseRecommender;

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRecommendedCourses() {
        when(courseRecommender.recommendedCourses()).thenReturn(Arrays.asList("Course1", "Course2"));
        List<String> recommendedCourses = courseService.getRecommendedCourses();
        assertNotNull(recommendedCourses);
        assertEquals(2, recommendedCourses.size());
        assertTrue(recommendedCourses.contains("Course1"));
    }

    @Test
    void testAddCourse() {
        Course course = new Course();
        course.setName("New Course");
        courseService.addCourse(course);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testUpdateCourse() {
        Course course = new Course();
        course.setName("Updated Course");
        courseService.updateCourse(course);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testGetCourseFound() {
        Course course = new Course();
        course.setName("Existing Course");
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        Course result = courseService.getCourse(1);
        assertNotNull(result);
        assertEquals("Existing Course", result.getName());
    }

    @Test
    void testGetCourseNotFound() {
        when(courseRepository.findById(1L)).thenReturn(Optional.empty());
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> courseService.getCourse(1));
        assertEquals("Course not found with id: 1", thrown.getMessage());
    }

    @Test
    void testDeleteCourse() {
        when(courseRepository.existsById(1L)).thenReturn(true);
        courseService.deleteCourse(1);
        verify(courseRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAllCoursesPaged() {
        Course course1 = new Course();
        course1.setName("Course1");
        Course course2 = new Course();
        course2.setName("Course2");

        Page<Course> coursesPage = new PageImpl<>(Arrays.asList(course1, course2));
        when(courseRepository.findAll(PageRequest.of(0, 10))).thenReturn(coursesPage);
        Page<Course> result = courseService.getAllCoursesPaged(0, 10);
        assertNotNull(result);
        assertEquals(2, result.getContent().size());
        assertTrue(result.getContent().get(0).getName().equals("Course1"));
        assertTrue(result.getContent().get(1).getName().equals("Course2"));
    }
}
