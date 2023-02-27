package me.devjian.learnhibernateandjpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import me.devjian.learnhibernateandjpa.course.Course;
import me.devjian.learnhibernateandjpa.course.jpa.CourseJpaRepository;
import me.devjian.learnhibernateandjpa.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcTemplate respository;
	
//	@Autowired
//	private CourseJpaRepository respository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Valorant", "Jwkim"));
		repository.save(new Course(2, "Guitar", "Jwkim"));
		repository.save(new Course(3, "English", "Jwkim"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Jwkim"));
		System.out.println(repository.findByAuthor("jwkim"));
		
		System.out.println(repository.findByName("Valorant"));
		System.out.println(repository.findByName("Guitar"));
	}
}
