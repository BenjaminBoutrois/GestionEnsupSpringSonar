package eu.ensup.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import eu.ensup.dao.ICourseDao;
import eu.ensup.domaine.Course;
import eu.ensup.domaine.Student;
import junit.framework.Assert;

public class CourseServiceTest {

	private static final Logger LOG = LogManager.getLogger(CourseServiceTest.class);
	
	// Création d'un mock
	@Mock
	ICourseDao iCourseDao;
	
	// Injection du mock à la classe service
	@InjectMocks
	private CourseService courseService;
	
	// Méthode d'initialisation - appelle de cette méthode avant l'appelle des différentes méthodes de test
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
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
		Mockito.when(iCourseDao.getAllCourses()).thenReturn(courses);
		// Inisialisation d'une nouvelle liste de cours à partir du renvoie de la méthode getAllCourse de la couche service
		List<Course> courses2 = courseService.getAllCourses();
		
		// Vérification de l'authenticité d'une information pour tous les cours récupérés à l'étape précedente
		Assert.assertEquals(courses2.get(0).getThemeCourse(), "Maven");
		Assert.assertEquals(courses2.get(1).getThemeCourse(), "Management");
		Mockito.verify(iCourseDao).getAllCourses();
	}
}
