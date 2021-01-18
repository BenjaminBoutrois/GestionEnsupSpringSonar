package eu.ensup.partiel_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.partiel_spring.entities.Student;
import eu.ensup.partiel_spring.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	

	@Override
	public List<Student> getAllStudents(){
		return (List<Student>) studentRepo.findAll();
	}

	
	@Override
	public Student findById(Long id) {		
		return studentRepo.findById(id).get();
	}


	@Override
	public void createStudent(Student student) {		
		studentRepo.save(student);
	}


	@Override
	public void updateStudent(Student student) {
		studentRepo.save(student);
	}
	
	@Override
	public void deleteStudent(Student student) {
		studentRepo.delete(student);
	}

}
