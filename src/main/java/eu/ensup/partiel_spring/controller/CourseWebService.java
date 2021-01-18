package eu.ensup.partiel_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.partiel_spring.entities.Course;
import eu.ensup.partiel_spring.service.ICourseService;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseWebService {
	
	@Autowired
	private ICourseService courseService;
	
	public CourseWebService(ICourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping("/getAll")
	public List<Course> getAllCourse(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/detail/{id}")
	public Course getCourseById(@PathVariable(value = "id") String theme){
		return courseService.getCourseById(theme);
	}
	
	@PostMapping("/create")
	public void createCourse(@Validated @RequestBody Course course) {
		courseService.createCourse(course);
	}
	
	@PutMapping("/update/{themeCourse}")
	public void updateCourse(@PathVariable (value = "themeCourse") String themeCourse, @RequestBody Course course) {
		
		Course courseFound = courseService.getCourseById(themeCourse);
		courseFound.setThemeCourse(course.getThemeCourse());
		courseService.updateCourse(courseFound);
	}

}
