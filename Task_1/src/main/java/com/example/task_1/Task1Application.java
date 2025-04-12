package com.example.task_1;

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
		};
	}

}
