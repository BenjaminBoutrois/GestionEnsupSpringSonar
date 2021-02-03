package eu.ensup.service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import eu.ensup.domaine.Student;
import eu.ensup.domaine.User;

/**
 * Classe StudentService : Fait le lien entre le lanceur et le DAO concernant
 * les étudiants.
 * 
 * @author 33651
 *
 */
public class StudentService implements IStudentService
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(StudentService.class);

	private static final String URL = "http://localhost:8081/SpringMVC/servlet/";

	// Constructors

	public StudentService()
	{
		super();
		LOG.info("Démarrage du service StudentService");
	}

	// Methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#createStudent(eu.ensup.
	 * jpaGestionEnsup.domaine.Student)
	 */
	public void createStudent(Student student)
	{
		LOG.info("Appel de la méthode createStudent() du dao");

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(URL).path("student/create");

//		String input = student.toJson();
		
		Response response = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		String input;
		
		try {
			input = objectMapper.writeValueAsString(student);
			response = webTarget.request("application/json").post(Entity.json(input));
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getStudent(int)
	 */
	public Student getStudent(int id)
	{
		LOG.info("Appel de la méthode getStudent() du dao");
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target(URL).path("student/detail/" + id);

		Response response = webTarget.request("application/json").get();
		
		return response.readEntity(Student.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.ensup.jpaGestionEnsup.service.IStudentService#getStudentByMail(java.lang.
	 * String)
	 */
	public Student getStudentByMail(String mail)
	{
		LOG.info("Appel de la méthode getStudentByMail() du dao");
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target(URL).path("student/getByMail/" + mail);

		Response response = webTarget.request("application/json").get();
		
		return response.readEntity(Student.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getAllStudents()
	 */
	public List<Student> getAllStudents()
	{
		LOG.info("Appel de la méthode getAllStudents() du dao");
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target(URL).path("student/getAll");

		Response response = webTarget.request("application/json").get();

		return response.readEntity(new GenericType<List<Student>>()
		{
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#deleteStudent(int)
	 */
	public void deleteStudent(int id)
	{
		LOG.info("Appel de la méthode deleteStudent() du dao");

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(URL).path("student/delete/" + id);

		Response response = webTarget.request("application/json").delete();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#updateStudent(eu.ensup.
	 * jpaGestionEnsup.domaine.Student)
	 */
	public void updateStudent(int oldStudentId, Student student)
	{
		LOG.info("Appel de la méthode updateStudent() du dao");

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(URL).path("student/update/" + oldStudentId);

		Response response = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		String input;
		
		try {
			input = objectMapper.writeValueAsString(student);
			response = webTarget.request("application/json").put(Entity.json(input));
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Response response = webTarget.request("application/json").put(Entity.json(input));
	}

	/**
	 * Recherche un ou plusieurs étudiants en fonction de leur données.
	 * 
	 * @param firstName Le prénom du ou des étudiants à chercher.
	 * @param lastName  Le nom de famille du ou des étudiants à chercher.
	 * @return La liste des étudiants correspondant au prénom et au nom entrés.
	 */
	public List<Student> searchStudent(String firstName, String lastName)
	{
		LOG.info("Appel de la méthode searchStudent() du dao");
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target(URL).path("student/search/")
				.queryParam("firstName", firstName).queryParam("lastName", lastName);

		Response response = webTarget.request("application/json").get();

		return response.readEntity(new GenericType<List<Student>>()
		{
		});
	}
}
