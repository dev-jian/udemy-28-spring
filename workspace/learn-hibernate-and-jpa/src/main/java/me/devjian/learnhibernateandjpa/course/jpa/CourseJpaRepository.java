package me.devjian.learnhibernateandjpa.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import me.devjian.learnhibernateandjpa.course.Course;

@Transactional
@Repository
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Course insert(Course course) {
		
		return entityManager.merge(course);
	}
	
	public Course findById(long id) {
		
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
