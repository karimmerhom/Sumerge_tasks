package com.example.task_1_new_bean.Classes;


import com.example.task_1_new_bean.Interfaces.CourseRecommender;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ReactCourseRecommender implements CourseRecommender {
    @Override
    public List<String> recommendedCourses() {
        return Arrays.asList("React Basics", "Advanced React");
    }
}
