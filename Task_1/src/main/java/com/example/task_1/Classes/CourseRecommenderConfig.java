package com.example.task_1.Classes;

import com.example.task_1_new_bean.Interfaces.CourseRecommender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(com.example.task_1_new_bean.Classes.CourseRecommenderConfig.class)
public class CourseRecommenderConfig {

    @Bean
    @Qualifier("explicitJavaCourseRecommender")
    public CourseRecommender JavaCourseRecommender() {
        return new JavaCourseRecommender();
    }

    @Bean
    @Qualifier("explicitPythonCourseRecommender")
    public CourseRecommender PythonCourseRecommender() {
        return new PythonCourseRecommender();
    }


}
