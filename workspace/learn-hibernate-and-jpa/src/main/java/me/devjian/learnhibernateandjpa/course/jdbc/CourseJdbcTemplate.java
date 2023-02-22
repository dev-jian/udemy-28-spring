package me.devjian.learnhibernateandjpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import me.devjian.learnhibernateandjpa.course.Course;

@Repository
public class CourseJdbcTemplate {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
			"""
				insert into course(id, name, author)
				values(?, ?, ?)	
			""";
	
	private static String DELETE_QUERY = 
			"""
				delete from course WHERE id = ?
			""";
	
	private static String SELECT_QUERY = 
			"""
				select * from course WHERE id = ? 
			""";
	
	private static String UPDATE_QUERY = 
			"""
				update course set 
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long courseId) {
		springJdbcTemplate.update(DELETE_QUERY, courseId);
	}
	
	public Course findById(long courseId) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), courseId);
	}
}
