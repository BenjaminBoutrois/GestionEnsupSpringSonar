package eu.ensup.partiel_spring.service;

import java.util.List;

import eu.ensup.partiel_spring.entities.Course;
import eu.ensup.partiel_spring.entities.Student;

public interface ICourseService {

	List<Course> getAllCourses();

	Course getCourseById(String theme);

	void createCourse(Course Course);

	void updateCourse(Course Course);

	List<Course> getListCourseByStudent(Student student);

}