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

import eu.ensup.partiel_spring.entities.Student;
import eu.ensup.partiel_spring.entities.User;
import eu.ensup.partiel_spring.repositories.UserRepository;
import eu.ensup.partiel_spring.service.UserServiceImpl;

public class UserServiceTest {

private static final Logger LOG = LogManager.getLogger(StudentServiceTest.class);
	
    //Création d'un mock
	@Mock
	UserRepository userRepository;
	
	// Injection du mock à la classe service
	@InjectMocks
	private UserServiceImpl userService;
	
	// Méthode d'initialisation - appelle de cette méthode avant l'appelle des différentes méthodes de test
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getUserByIDTest() {		
		/* 
		 * Scénario de test :
		 * La demande de lecture d'un utilisateur à partir de son identifiant nous ramène bien
		 * la totalité des informations de cet utilisateur 
		 */
		
		// Création d'un utilisateur
		User user = new User("CedNoz", "azerty");
		// Imposer un comportement au mock (stubbing)
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		// Créationde l'utilisateur a tester
		User result = userService.getUserById(1L);
		// Vérification que le mock ramène bien les bonnes informations
		Assert.assertEquals(user.getLogin(), result.getLogin());
	}
	
	@Test
	public void getUserTest() {		
		/* 
		 * Scénario de test :
		 * La demande de lecture d'un utilisateur à partir d'une instanciation nous ramène bien
		 * la totalité des informations de cet utilisateur 
		 */
		
		// Création d'un utilisateur
		User user = new User("CedNoz", "azerty");
		// Imposer un comportement au mock (stubbing)
		Mockito.when(userService.getUser(user)).thenReturn(user);
		// Créationde l'utilisateur a tester
		User result = userService.getUser(user);
		// Vérification que le mock ramène bien les bonnes informations
		Assert.assertEquals(user.getLogin(), result.getLogin());
	}
	
	@Test
	public void readAllUserTest() {
		/* 
		 * Scénario de test :
		 * La demande de lecture de tous les étudiants nous ramène bien
		 * la totalité des informations de tous les étudiants 
		 */
		
		// Création de deux utilisateurs
		User user1 = new User("user", "azerty");
		User user2 = new User("user2", "qwerty");
		// Créationd'une liste vide
		ArrayList<User> users = new ArrayList<User>();
		//Insertion des utilisateurs dans la liste
		users.add(user1);
		users.add(user2);
		
		// Imposer un comportement au mock (stubbing)
		Mockito.when(userRepository.findAll()).thenReturn(users);
		
		// Création de la liste a tester
		List<User> result = userService.getAllusers();
		// Vérification des information de chaque utilisateur dans la liste
		Assert.assertEquals(result.get(0).getLogin(), "user");
		Assert.assertEquals(result.get(1).getLogin(), "user2");
		Mockito.verify(userRepository).findAll();
	}
	
	@Test
	public void createUserTest() {
		/* 
		 * Scénario de test :
		 * Les informations envoyées en base de donnée est récupérable par la suite 
		 */
		
		// Création d'un étudiant
		User user = new User("CedNoz", "azerty");
		// Imposer un comportement au mock (stubbing)
		Mockito.when(userRepository.save(user)).thenReturn(user);
		// appelle de la méthode createStudent de la couche service avec l'étudiant crée en paramètre
		userService.createUser(user);
		// Vérification que la méthode createStudent de la couche service a bien appelé la méthode 
		// createStudent de la couche dao
		Mockito.verify(userRepository, Mockito.times(1)).save(user);
	}
	
	@Test
	public void updateUserTest() {
//		/* 
//		 * Scénario de test :
//		 * Vérifier si la méthode updateStudent de la couche service appelle bien la méthode updateStudent
//		 * de la couche dao
//		 */
//		
//		// Création d'un nouvelle utilisateur
//		User user = new User("CedNoz", "azerty");
//		// Imposer un comportement au mock (stubbing)
//		Mockito.when(userRepository.save(user)).thenReturn(user);
//		// Appelle de la méthode updateStudent avec en paramètre l'id de l'étudiant à modifier ainsi que l'instance de l'objet student
//		userService.updateUser(user);
//		User result = userService.getUser(user);
//		// Vérification que la méthode updateStudent de la couche service a bien appelé la méthode 
//		// updateStudent de la couche dao
//		Mockito.verify(studentRepository, Mockito.times(1)).save(student);
	}
}
