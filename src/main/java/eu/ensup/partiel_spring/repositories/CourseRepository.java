package eu.ensup.partiel_spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.partiel_spring.entities.Course;
import eu.ensup.partiel_spring.entities.Student;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByStudents(Student student);

}