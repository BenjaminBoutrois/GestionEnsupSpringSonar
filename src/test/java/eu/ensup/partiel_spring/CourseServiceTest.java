package eu.ensup.partiel_spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eu.ensup.partiel_spring.entities.Course;
import eu.ensup.partiel_spring.entities.Student;
import eu.ensup.partiel_spring.entities.User;
import eu.ensup.partiel_spring.repositories.CourseRepository;
import eu.ensup.partiel_spring.service.CourseServiceImpl;

public class CourseServiceTest {

	private static final Logger LOG = LogManager.getLogger(CourseServiceTest.class);
	
	// Création d'un mock
	@Mock
	CourseRepository courseRepository;
	
	// Injection du mock à la classe service
	@InjectMocks
	private CourseServiceImpl courseService;
	
	// Méthode d'initialisation - appelle de cette méthode avant l'appelle des différentes méthodes de test
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createCourseTest() {
		/* 
		 * Scénario de test :
		 * Les informations envoyées en base de donnée sont récupérable par la suite 
		 */
		
		// Création d'un cours
		Course course = new Course("Java", 35);
		// Imposer un comportement au mock (stubbing)
		Mockito.when(courseRepository.save(course)).thenReturn(course);
		// appelle de la méthode createCourse de la couche service avec le cours crée en paramètre
		courseService.createCourse(course);
		// Vérification que la méthode save à bien été appellé
		Mockito.verify(courseRepository, Mockito.times(1)).save(course);
	}
	
	@Test
	public void getCourseByIDTest() {
		/* 
		 * Scénario de test :
		 * La demande de lecture d'un cours à partir de son identifiant nous ramène bien
		 * la totalité des informations de ce cours 
		 */
		
		// Création d'un cours
		Course course = new Course("Java", 35);
		// Imposer un comportement au mock (stubbing)
		Mockito.when(courseRepository.findById("Java")).thenReturn(Optional.of(course));
		// Création du cours a tester
		Course result = courseService.getCourseById("Java");
		// Vérification que le mock ramène bien les bonnes informations
		Assert.assertEquals(course.getThemeCourse(), result.getThemeCourse());
	}
	
	@Test
	public void readAllCourseTest() {
		/* 
		 * Scénario de test :
		 * La demande de lecture de tous les cours nous ramène bien
		 * la totalité des informations de tous les cours 
		 */
		
		// Création de deux cours
		Course course1 = new Course("Maven", 40);
		Course course2 = new Course("Management", 15);
		// Création d'une liste de cours  vide
		ArrayList<Course> courses = new ArrayList<Course>();
		// Insértion des cours dans la liste
		courses.add(course1);
		courses.add(course2);
		
		// Imposer un comportement au mock (stubbing)
		Mockito.when(courseRepository.findAll()).thenReturn(courses);
		// Inisialisation d'une nouvelle liste de cours à partir du renvoie de la méthode getAllCourse de la couche service
		List<Course> courses2 = courseService.getAllCourses();
		
		// Vérification de l'authenticité d'une information pour tous les cours récupérés à l'étape précedente
		Assert.assertEquals(courses2.get(0).getThemeCourse(), "Maven");
		Assert.assertEquals(courses2.get(1).getThemeCourse(), "Management");
		Mockito.verify(courseRepository).findAll();
	}
	
	@Test
	public void updateCourseTest() {
		
	}
	
	@Test
	public void associateCourseTest() {
//		/* 
//		 * Scénario de test :
//		 * Vérifier si la méthode associateCourse de la couche service appelle bien la méthode associateCourse
//		 * de la couche dao
//		 */
//		
//		// Création des valeurs du fichier JSON
//		String course = "Java";
//		int id = 1;
//		String input = "{\"course\":\"" + course + "\",\"id\":" + id + "}";
//		// Création du fichier JSON
//		ObjectNode node = null;
//		try {
//			node = (ObjectNode) new ObjectMapper().readTree(input);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		
//		// Imposer un comportement au mock (stubbing)
//		Mockito.doNothing().when(iCourseDao).associateCourse(course, id);
//		// Vérification que la méthode associateCourse de la couche service a bien appelé la méthode 
//		// associateCourse de la couche dao
//		courseService.associateCourse(node);
//		Mockito.verify(iCourseDao, Mockito.times(1)).associateCourse(course, id);
	}
}
