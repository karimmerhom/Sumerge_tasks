package com.example.task_1;

import com.example.task_1.Models.Course;
import com.example.task_1.Services.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Task1Application {

	public static void main(String[] args) {
		SpringApplication.run(Task1Application.class, args);
	}

	@Bean
	public CommandLineRunner run(CourseService courseService) {
		return args -> {
			System.out.println(courseService.getRecommendedCourses());
			Course newCourse = new Course();
			newCourse.setName("Spring JDBC");
			newCourse.setDescription("A hands-on course on JDBC with Spring Boot");
			newCourse.setCredit(4);
			courseService.addCourse(newCourse);
			System.out.println("Course Added");

			Course fetched = courseService.getCourse(1);
			System.out.println("Course with ID 1: " + fetched);

			fetched.setCredit(5);
			courseService.updateCourse(fetched);
			System.out.println("Updated course credit to 5 for: " + fetched.getName());

		};
	}

}
