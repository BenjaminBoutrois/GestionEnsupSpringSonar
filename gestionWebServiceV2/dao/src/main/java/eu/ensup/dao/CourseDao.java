package eu.ensup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.domaine.Course;
import eu.ensup.domaine.Student;

/**
 * Classe CRUD pour les cours.
 * @author 33651
 *
 */
public class CourseDao implements ICourseDao
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(CourseDao.class);

	// Constructors

	/**
	 * Construit le CourseDao à partir de l'entityManager.
	 * 
	 * @param entityManager
	 */
	public CourseDao()
	{
		super();
		LOG.info("Démarrage du dao CourseDao");
	}

	// Methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.ensup.jpaGestionEnsup.dao.ICourseDao#associateCourse(java.lang.String,
	 * int)
	 */
	public void associateCourse(String courseTheme, int idStudent)
	{
		LOG.info("Association du cours \"" + courseTheme + "\" à l'étudiant à l'id \"" + idStudent + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student student = entityManager.find(Student.class, idStudent);

		if (student == null)
		{
			LOG.error("L'id \"" + idStudent + "\" n'est attribué à aucun étudiant.");
			System.out.println("Cet id n'est attribué à aucun étudiant.");
			return;
		}

		// Ouverture transaction
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		student.getCourses().add(entityManager.find(Course.class, courseTheme));

//    	entityManager.persist(student);

		// Fermeture transaction
		transaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.dao.ICourseDao#getAllCourses()
	 */
	public List<Course> getAllCourses()
	{
		LOG.info("Récupération de tous les cours");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Course> courses = entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return courses;
	}
}
