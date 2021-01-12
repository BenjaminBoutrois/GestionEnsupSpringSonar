package eu.ensup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.domaine.User;

/**
 * Classe CRUD pour les utilisateurs.
 * 
 * @author 33651
 *
 */
public class UserDao implements IUserDao
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(UserDao.class);

	// Constructors

	/**
	 * Construit le UserDao à partir de l'entityManager.
	 * 
	 * @param entityManager
	 */
	public UserDao()
	{
		super();
		LOG.info("Démarrage du dao UserDao");
	}

	// Methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.dao.IUserDao#getUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User getUser(String login, String password)
	{
		LOG.info("Récupération de l'utilisateur au login \"" + login + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		tx.commit();

		List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();

		User user = users.stream().filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
				.findFirst().get();

		entityManager.close();
		entityManagerFactory.close();

		return user;
	}
}
