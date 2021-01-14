package eu.ensup.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eu.ensup.dao.IStudentDao;
import eu.ensup.dao.StudentDao;
import eu.ensup.domaine.Student;

/**
 * Classe StudentService : Fait le lien entre le lanceur et le DAO concernant
 * les étudiants.
 * 
 * @author 33651
 *
 */
@Path("/studentService")
public class StudentService implements IStudentService
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(StudentService.class);

	private IStudentDao studentDao;

	// Constructors

	public StudentService()
	{
		super();
		LOG.info("Démarrage du service StudentService");
		studentDao = new StudentDao();
	}

	public StudentService(IStudentDao studentDao)
	{
		super();
		this.studentDao = studentDao;
		LOG.info("Démarrage du service StudentService");
	}
	
	// Methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#createStudent(eu.ensup.
	 * jpaGestionEnsup.domaine.Student)
	 */
	@POST
	@Path("/createStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createStudent(Student student)
	{
		LOG.info("Appel de la méthode createStudent() du dao");
		studentDao.createStudent(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getStudent(int)
	 */
	@GET
	@Path("/getStudent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id") int id)
	{
		LOG.info("Appel de la méthode getStudent() du dao");

		Student student = studentDao.getStudent(id);

		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.ensup.jpaGestionEnsup.service.IStudentService#getStudentByMail(java.lang.
	 * String)
	 */
	@GET
	@Path("/getStudentByMail/{mail}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentByMail(@PathParam("mail") String mail)
	{
		LOG.info("Appel de la méthode getStudentByMail() du dao");

		Student student = studentDao.getStudentByMail(mail);

		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getAllStudents()
	 */
	@GET
	@Path("/getAllStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents()
	{
		LOG.info("Appel de la méthode getAllStudents() du dao");

		return studentDao.getAllStudents();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#deleteStudent(int)
	 */
	@DELETE
	@Path("/deleteStudent/{id}")
	public void deleteStudent(@PathParam("id") int id)
	{
		LOG.info("Appel de la méthode deleteStudent() du dao");

		studentDao.deleteStudent(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#updateStudent(eu.ensup.
	 * jpaGestionEnsup.domaine.Student)
	 */
	@PUT
	@Path("/updateStudent/{oldStudentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateStudent(@PathParam("oldStudentId") int oldStudentId, Student student)
	{
		LOG.info("Appel de la méthode updateStudent() du dao");

		studentDao.updateStudent(oldStudentId, student);
	}

	/**
	 * Recherche un ou plusieurs étudiants en fonction de leur données.
	 * 
	 * @param firstName Le prénom du ou des étudiants à chercher.
	 * @param lastName  Le nom de famille du ou des étudiants à chercher.
	 * @return La liste des étudiants correspondant au prénom et au nom entrés.
	 */
	@GET
	@Path("/searchStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> searchStudent(@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName)
	{
		LOG.info("Appel de la méthode searchStudent() du dao");

		List<Student> students = studentDao.searchStudent(firstName, lastName);

		return students;
	}
}
