package eu.ensup.partiel_spring.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.partiel_spring.entities.Course;
import eu.ensup.partiel_spring.entities.Student;
import eu.ensup.partiel_spring.repositories.StudentRepository;
import eu.ensup.partiel_spring.service.ICourseService;
import eu.ensup.partiel_spring.service.IStudentService;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentWebService {
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ICourseService courseService;
	
	
	
	public StudentWebService(IStudentService studentService) {
		this.studentService = studentService;
	}
	

	@GetMapping("/getAll")
	public List<Student> getAllStudent(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping(path = "/detail/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable(name = "id") Long id){
		System.out.println("ici id de etudiant"+id);
		Student student = studentService.findById(id);
		return student;
	}
	
	@PostMapping("/create")
	public void createStudent(@Validated @RequestBody Student student) {
		studentService.createStudent(student);
	}
	
	
	@PutMapping("/update/{id}")
	public void updateStudent(@PathVariable (value = "id") Long id, @RequestBody Student student) {
		
		Student studentFound = studentService.findById(id);
		
//		Set<Course> studentFoundCourses = studentFound.getCourses();
//		studentFoundCourses.addAll( student.getCourses() );
//		studentFound.setCourses( studentFoundCourses );
		
		studentFound.setAddress( student.getAddress() );
		studentFound.setBirthDate( student.getBirthDate() );
		studentFound.setFirstName( student.getFirstName() );
		studentFound.setLastName( student.getLastName() );
		studentFound.setMailAddress( student.getMailAddress() );
		studentFound.setNumberPhone( student.getNumberPhone() );
		
		studentService.updateStudent(studentFound);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable (value = "id") Long id) {
		
		Student studentFound = studentService.findById(id);
		studentService.deleteStudent(studentFound);
		
	}
	
	

}
