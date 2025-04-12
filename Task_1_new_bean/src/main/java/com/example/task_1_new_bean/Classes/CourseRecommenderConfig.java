package com.example.task_1_new_bean.Classes;


import com.example.task_1_new_bean.Interfaces.CourseRecommender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseRecommenderConfig {

    @Bean
    @Qualifier("explicitReactCourseRecommender")
    public CourseRecommender ReactCourseRecommender() {
        return new ReactCourseRecommender();
    }

}
