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

import eu.ensup.dao.IStudentDao;
import eu.ensup.domaine.Student;
import junit.framework.Assert;

public class StudentServiceTest {

	private static final Logger LOG = LogManager.getLogger(StudentServiceTest.class);
	
	
	// Création d'un mock
	@Mock
	IStudentDao iStudentDao;
	
	// Injection du mock à la classe service
	@InjectMocks
	private StudentService studentService;
	
	// Méthode d'initialisation - appelle de cette méthode avant l'appelle des différentes méthodes de test
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createStudentTest() {
		/* 
		 * Scénario de test :
		 * Vérifier si la méthode createStudent de la couche service appelle bien la méthode createStudent
		 * de la couche dao
		 */
		
		// Création d'un étudiant
		Student student = new Student("test", "test", "test", "test", "test", "test");
		// Imposer un comportement au mock (stubbing)
		Mockito.doNothing().when(iStudentDao).createStudent(student);
		// appelle de la méthode createStudent de la couche service avec l'étudiant crée en paramètre
		studentService.createStudent(student);
		// Vérification que la méthode createStudent de la couche service a bien appelé la méthode 
		// createStudent de la couche dao
		Mockito.verify(iStudentDao, Mockito.times(1)).createStudent(student);
	}
	
	@Test
	public void getStudentByIDTest() {
		/* 
		 * Scénario de test :
		 * La demande de lecture d'un étudiant à partir de son identifiant nous ramène bien
		 * la totalité des informations de cet étudiant 
		 */
		
		// Imposer un comportement au mock (stubbing)
		Mockito.when(iStudentDao.getStudent(1)).thenReturn(new Student("test", "test", "test", "test", "test", "test"));
		// Initialisation d'un étudiant à partir du renvoie de la méthode getStudent de la couche service 
		// avec l'id de l'étudiant en paramètre
		Student student = studentService.getStudent(1);
		// Vérification de l'authenticité d'une information de l'étudiant récupéré à l'étape précedente
		Assert.assertEquals(student.getFirstName(), "test");
		Mockito.verify(iStudentDao).getStudent(1);
	}
	
	@Test
	public void getStudentByEmailTest() {
		/* 
		 * Scénario de test :
		 * La demande de lecture d'un étudiant à partir de son email nous ramène bien
		 * la totalité des informations de cet étudiant 
		 */
		
		// Imposer un comportement au mock (stubbing)
		Mockito.when(iStudentDao.getStudentByMail("test")).thenReturn(new Student("test", "test", "test", "test", "test", "test"));
		// Initialisation d'un étudiant à partir du renvoie de la méthode getStudent de la couche service 
		// avec l'email de l'étudiant en paramètre
		Student student = studentService.getStudentByMail("test");
		// Vérification de l'authenticité d'une information de l'étudiant récupéré à l'étape précedente
		Assert.assertEquals(student.getMailAddress(), "test");
		Mockito.verify(iStudentDao).getStudentByMail("test");
	}
	
	@Test
	public void readAllStudentTest() {
		/* 
		 * Scénario de test :
		 * La demande de lecture de tous les étudiants nous ramène bien
		 * la totalité des informations de tous les étudiants 
		 */
		
		// Création de deux étudiants
		Student student1 = new Student("test1", "test1", "test1", "test1", "test1", "test1");
		Student student2 = new Student("test2", "test2", "test2", "test2", "test2", "test2");
		// Création d'une liste d'étudiant vide
		ArrayList<Student> students = new ArrayList<Student>();
		// Insértion des étudiants dans la liste
		students.add(student1);
		students.add(student2);
		
		// Imposer un comportement au mock (stubbing)
		Mockito.when(iStudentDao.getAllStudents()).thenReturn(students);
		// Inisialisation d'une nouvelle liste d'étudiants à partir du renvoie de la méthode getAllStudents de la couche service
		List<Student> students2 = studentService.getAllStudents();
		
		// Vérification de l'authenticité d'une information pour tous les étudiants récupérés à l'étape précedente
		Assert.assertEquals(students2.get(0).getFirstName(), "test1");
		Assert.assertEquals(students2.get(1).getFirstName(), "test2");
		Mockito.verify(iStudentDao).getAllStudents();
	}
	
	@Test
	public void updateStudentTest() {
		/* 
		 * Scénario de test :
		 * Vérifier si la méthode updateStudent de la couche service appelle bien la méthode updateStudent
		 * de la couche dao
		 */
		
		// Création d'un nouvelle étudiant
		Student student = new Student("test1", "test1", "test1", "test1", "test1", "test1");
		// Imposer un comportement au mock (stubbing)
		Mockito.doNothing().when(iStudentDao).updateStudent(1, student);
		// Appelle de la méthode updateStudent avec en paramètre l'id de l'étudiant à modifier ainsi que l'instance de l'objet student
		studentService.updateStudent(1, student);
		// Vérification que la méthode updateStudent de la couche service a bien appelé la méthode 
		// updateStudent de la couche dao
		Mockito.verify(iStudentDao, Mockito.times(1)).updateStudent(1, student);
	}
	
	@Test
	public void deleteStudentTest() {
		/* 
		 * Scénario de test :
		 * Vérifier si la méthode deleteStudent de la couche service appelle bien la méthode deleteStudent
		 * de la couche dao
		 */
		
		// Imposer un comportement au mock (stubbing)
		Mockito.doNothing().when(iStudentDao).deleteStudent(1);
		// Appelle de la méthode deleteStudent avec en paramètre l'id de l'étudiant à supprimert
		studentService.deleteStudent(1);
		// Vérification que la méthode deleteStudent de la couche service a bien appelé la méthode 
		// deleteStudent de la couche dao
		Mockito.verify(iStudentDao, Mockito.times(1)).deleteStudent(1);
	}	
}
