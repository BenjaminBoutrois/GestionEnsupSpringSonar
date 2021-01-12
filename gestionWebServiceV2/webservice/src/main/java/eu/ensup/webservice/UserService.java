package eu.ensup.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.node.ObjectNode;

import eu.ensup.dao.IUserDao;
import eu.ensup.dao.UserDao;
import eu.ensup.domaine.User;

/**
 * Classe UserService : Fait le lien entre le lanceur et le DAO concernant les
 * utilisateurs.
 * 
 * @author 33651
 *
 */
@Path("/userService")
public class UserService implements IUserService
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(UserService.class);

	IUserDao dao;

	// Constructors

	/**
	 * Construit le UserService en fonction d'un entityManager.
	 * 
	 * @param entityManager
	 */
	public UserService()
	{
		super();
		LOG.info("Démarrage du service UserService");
		dao = new UserDao();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IUserService#getUser(java.lang.String,
	 * java.lang.String)
	 */
	@POST
	@Path("/getUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(ObjectNode loginInput)
	{
		LOG.info("Appel de la méthode getUser() du dao");

		String login = null;
		String password = null;

		login = loginInput.get("login").asText();
		password = loginInput.get("password").asText();

		User user = dao.getUser(login, password);

		return user;
	}
}
