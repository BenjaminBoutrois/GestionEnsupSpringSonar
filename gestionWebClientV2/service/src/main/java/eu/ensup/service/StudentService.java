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

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import eu.ensup.domaine.Student;

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

	private static final String URL = "http://localhost:8080/web/";

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

		WebTarget webTarget = client.target(URL).path("rest/studentService/createStudent");

		String input = student.toJson();

		Response response = webTarget.request("application/json").post(Entity.json(input));
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

		WebTarget webTarget = client.target(URL).path("rest/studentService/getStudent/" + id);

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

		WebTarget webTarget = client.target(URL).path("rest/studentService/getStudentByMail/" + mail);

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

		WebTarget webTarget = client.target(URL).path("rest/studentService/getAllStudents");

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

		WebTarget webTarget = client.target(URL).path("rest/studentService/deleteStudent/" + id);

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

		WebTarget webTarget = client.target(URL).path("rest/studentService/updateStudent/" + oldStudentId);

		String input = student.toJson();

		Response response = webTarget.request("application/json").put(Entity.json(input));
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

		WebTarget webTarget = client.target(URL).path("rest/studentService/searchStudent")
				.queryParam("firstName", firstName).queryParam("lastName", lastName);

		Response response = webTarget.request("application/json").get();

		return response.readEntity(new GenericType<List<Student>>()
		{
		});
	}
}
