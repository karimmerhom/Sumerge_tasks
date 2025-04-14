package com.example.task_1.Services;

import com.example.task_1.Mappers.CourseRowMapper;
import com.example.task_1.Models.Course;
import com.example.task_1_new_bean.Interfaces.CourseRecommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private  CourseRecommender courseRecommender;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CourseRowMapper rowMapper;

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

    public void addCourse(Course c) {
        String sql = "INSERT INTO course (name, description, credit) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, c.getName(), c.getDescription(), c.getCredit());
    }

    public void updateCourse(Course c) {
        String sql = "UPDATE course SET name = ?, description = ?, credit = ? WHERE id = ?";
        jdbcTemplate.update(sql, c.getName(), c.getDescription(), c.getCredit(), c.getId());
    }

    public Course getCourse(int id) {
        String sql = "SELECT * FROM course WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void deleteCourse(int id) {
        String sql = "DELETE FROM course WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
