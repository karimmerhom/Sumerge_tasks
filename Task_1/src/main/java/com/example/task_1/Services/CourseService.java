package com.example.task_1.Services;

import com.example.task_1_new_bean.Interfaces.CourseRecommender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private  CourseRecommender courseRecommender;

    // Constructor-based autowiring
//    public CourseService(@Qualifier("javaCourseRecommender") CourseRecommender courseRecommender) {
//        this.courseRecommender = courseRecommender;
//    }

//    public CourseService(@Qualifier("explicitJavaCourseRecommender") CourseRecommender courseRecommender) {
//        this.courseRecommender = courseRecommender;
//    }

        public CourseService(@Qualifier("explicitReactCourseRecommender") CourseRecommender courseRecommender) {
        this.courseRecommender = courseRecommender;
    }

    // Setter-based autowiring
//    @Autowired
//    public void setCourseRecommender(CourseRecommender courseRecommender) {
//        this.courseRecommender = courseRecommender;
//    }

    public List<String> getRecommendedCourses() {
        return courseRecommender.recommendedCourses();
    }
}
