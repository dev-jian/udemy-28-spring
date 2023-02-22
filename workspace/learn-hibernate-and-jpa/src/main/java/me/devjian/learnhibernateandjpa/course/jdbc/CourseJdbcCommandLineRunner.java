package me.devjian.learnhibernateandjpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import me.devjian.learnhibernateandjpa.course.Course;
import me.devjian.learnhibernateandjpa.course.jpa.CourseJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcTemplate respository;
	
	@Autowired
	private CourseJpaRepository respository;
	
	@Override
	public void run(String... args) throws Exception {
		respository.insert(new Course(1, "Valorant", "Jwkim"));
		respository.insert(new Course(2, "Guitar", "Jwkim"));
		respository.insert(new Course(3, "English", "Jwkim"));
		
		respository.deleteById(1);
		
		System.out.println(respository.findById(2));
		System.out.println(respository.findById(3));
	}
}
