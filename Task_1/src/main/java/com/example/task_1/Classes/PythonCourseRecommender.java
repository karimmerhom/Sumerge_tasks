package com.example.task_1.Classes;


import com.example.task_1_new_bean.Interfaces.CourseRecommender;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class PythonCourseRecommender implements CourseRecommender {
    @Override
    public List<String> recommendedCourses() {
        return Arrays.asList("Python Basics", "Advanced Python");
    }
}