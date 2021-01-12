package eu.ensup.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.domaine.Student;

/**
 * Classe CRUD pour les étudiants.
 * 
 * @author 33651
 *
 */
public class StudentDao implements IStudentDao
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(CourseDao.class);

	// Constructors

	/**
	 * Construit la classe StudentDao à partir de l'entityManager.
	 * 
	 * @param entityManager
	 */
	public StudentDao()
	{
		super();
		LOG.info("Démarrage du dao StudentDao");
	}

	// Methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#createStudent(eu.ensup.
	 * jpaGestionEnsup.domaine.Student)
	 */
	public void createStudent(Student student)
	{
		LOG.info("Création d'un étudiant : \"" + student + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(student);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#getStudent(int)
	 */
	public Student getStudent(int id)
	{
		LOG.info("Récupération de l'étudiant à l'id : \"" + id + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student student = entityManager.find(Student.class, id);

		entityManager.close();
		entityManagerFactory.close();

		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.ensup.jpaGestionEnsup.dao.IStudentDao#getStudentByMail(java.lang.String)
	 */
	public Student getStudentByMail(String mail)
	{
		LOG.info("Récupération de l'étudiant au mail : \"" + mail + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();

		Student student = students.stream().filter(s -> s.getMailAddress().equals(mail)).findFirst().get();

		entityManager.close();
		entityManagerFactory.close();

		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#getAllStudents()
	 */
	public List<Student> getAllStudents()
	{
		LOG.info("Récupération de tous les étudiants");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return students;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#deleteStudent(int)
	 */
	public void deleteStudent(int id)
	{
		LOG.info("Suppression de l'étudiant à l'id : \"" + id + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student student = entityManager.merge(getStudent(id));

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.remove(student);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#updateStudent(eu.ensup.
	 * jpaGestionEnsup.domaine.Student)
	 */
	public void updateStudent(int oldStudentId, Student newStudent)
	{
		LOG.info("Mise à jour de l'étudiant à l'id : \"" + oldStudentId + "\" avec les données : \"" + newStudent + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student oldStudent = entityManager.merge(getStudent(oldStudentId));

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		oldStudent.setFirstName(newStudent.getFirstName());
		oldStudent.setLastName(newStudent.getLastName());
		oldStudent.setAddress(newStudent.getAddress());
		oldStudent.setMailAddress(newStudent.getMailAddress());
		oldStudent.setNumberPhone(newStudent.getNumberPhone());
		oldStudent.setBirthDate(newStudent.getBirthDate());

		if (!(newStudent.getCourses() == null) && !newStudent.getCourses().isEmpty())
			oldStudent.setCourses(newStudent.getCourses());

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
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
		LOG.info("Recherche d'un étudiant par le nom : \"" + firstName + "\" et le prénom : \"" + lastName + "\"");
		List<Student> students = getAllStudents();

		return students.stream().filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
				.collect(Collectors.toList());
	}
}
