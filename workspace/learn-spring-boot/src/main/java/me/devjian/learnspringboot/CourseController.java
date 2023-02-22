package me.devjian.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		
		return Arrays.asList(new Course(1, "Learn AWS", "in28")
				, new Course(2, "Learn Spring", "in28"));
	}
}
