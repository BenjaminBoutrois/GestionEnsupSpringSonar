package eu.ensup.partiel_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.partiel_spring.entities.Course;
import eu.ensup.partiel_spring.entities.Student;
import eu.ensup.partiel_spring.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	public CourseServiceImpl(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	

	@Override
	public List<Course> getAllCourses(){
		return (List<Course>) courseRepo.findAll();
	}

	
	@Override
	public Course getCourseById(String theme) {
		return courseRepo.findById(theme).get();
	}
	
	@Override
	public List<Course> getListCourseByStudent(Student student) {
		return courseRepo.findByStudents(student);
	}


	@Override
	public void createCourse(Course Course) {
		courseRepo.save(Course);
	}


	@Override
	public void updateCourse(Course Course) {
		courseRepo.save(Course);
	}

}
