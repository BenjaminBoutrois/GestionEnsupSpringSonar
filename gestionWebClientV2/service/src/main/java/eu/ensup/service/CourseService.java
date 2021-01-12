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

import eu.ensup.domaine.Course;

/**
 * Classe CourseService : Fait le lien entre le lanceur et le DAO concernant les
 * cours.
 * 
 * @author 33651
 *
 */
public class CourseService implements ICourseService
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(CourseService.class);

	private static final String URL = "http://localhost:8080/web/";

	// Constructors

	/**
	 * Construit le CourseService en fonction de l'entityManager.
	 * 
	 * @param entityManager
	 */
	public CourseService()
	{
		super();
		LOG.info("Démarrage du service CourseService");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.ensup.jpaGestionEnsup.service.ICourseService#associateCourse(java.lang.
	 * String, int)
	 */
	public void associateCourse(String course, int id)
	{
		LOG.info("Appel de la méthode associateCourse() du dao");

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(URL).path("rest/courseService/associateCourse");

		String input = "{\"course\":\"" + course + "\",\"id\":" + id + "}";

		Response response = webTarget.request("application/json").post(Entity.json(input));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.ICourseService#getAllCourses()
	 */
	public List<Course> getAllCourses()
	{
		LOG.info("Appel de la méthode getAllCourses() du dao");
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target(URL).path("rest/courseService/getAllCourses");

		Response response = webTarget.request("application/json").get();

		return response.readEntity(new GenericType<List<Course>>()
		{
		});
	}
}
