package eu.ensup.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eu.ensup.dao.CourseDao;
import eu.ensup.dao.ICourseDao;
import eu.ensup.domaine.Course;

/**
 * Classe CourseService : Fait le lien entre le lanceur et le DAO concernant les
 * cours.
 * 
 * @author 33651
 *
 */
@Path("/courseService")
public class CourseService implements ICourseService
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(CourseService.class);

	ICourseDao dao;

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
		dao = new CourseDao();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.ensup.jpaGestionEnsup.service.ICourseService#associateCourse(java.lang.
	 * String, int)
	 */
	@POST
	@Path("/associateCourse")
	@Consumes(MediaType.APPLICATION_JSON)
	public void associateCourse(ObjectNode courseAssociation)
	{
		LOG.info("Appel de la méthode associateCourse() du dao");

		String course = null;
		int id = -1;

		course = courseAssociation.get("course").asText();
		id = courseAssociation.get("id").asInt();

		dao.associateCourse(course, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.ICourseService#getAllCourses()
	 */
	@GET
	@Path("/getAllCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses()
	{
		LOG.info("Appel de la méthode getAllCourses() du dao");
		return dao.getAllCourses();
	}
}
