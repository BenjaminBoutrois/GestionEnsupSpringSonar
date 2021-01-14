package eu.ensup.webservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eu.ensup.dao.IUserDao;
import eu.ensup.domaine.Student;
import eu.ensup.domaine.User;
import junit.framework.Assert;

public class UserServiceTest {

private static final Logger LOG = LogManager.getLogger(StudentServiceTest.class);
	
    //Création d'un mock
	@Mock
	IUserDao iUserDao;
	
	// Injection du mock à la classe service
	@InjectMocks
	private UserService userService;
	
	// Méthode d'initialisation - appelle de cette méthode avant l'appelle des différentes méthodes de test
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getUser() {
		/* 
		 * Scénario de test :
		 * La demande de lecture d'un utilisateur à partir de son login et mot de passe nous ramène bien
		 * la totalité des informations de cet utilisateur 
		 */
		
//		// Création des valeurs pour le fichier JSON
//		String login = "123";
//		String password = "azerty";
//		
//		String input = "{\"login\":\"" + login + "\",\"password\":" + password + "}";
//		
//		// Création du fichier JSON
//		ObjectNode node = null;
//		try {
//			node = (ObjectNode) new ObjectMapper().readTree(input);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		
//		// Imposer un comportement au mock (stubbing)
//		Mockito.when(iUserDao.getUser(login, password)).thenReturn(new User("test", "test"));
//		// Initialisation d'un étudiant à partir du renvoie de la méthode getStudent de la couche service 
//		// avec l'id de l'étudiant en paramètre
//		User user = userService.getUser(node);
//		// Vérification de l'authenticité d'une information de l'étudiant récupéré à l'étape précedente
//		Assert.assertEquals(user.getLogin(), "test");
//		Mockito.verify(iUserDao).getUser(login, password);
	}
}
