package me.devjian.learnhibernateandjpa.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.devjian.learnhibernateandjpa.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByAuthor(String author);

	List<Course> findByName(String name);
}
