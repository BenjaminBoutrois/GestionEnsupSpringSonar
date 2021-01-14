package eu.ensup.webservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eu.ensup.dao.IUserDao;

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
}
