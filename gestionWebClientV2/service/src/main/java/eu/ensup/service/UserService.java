package eu.ensup.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import eu.ensup.domaine.User;

/**
 * Classe UserService : Fait le lien entre le lanceur et le DAO concernant les
 * utilisateurs.
 * 
 * @author 33651
 *
 */
public class UserService implements IUserService
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(UserService.class);
    
    private static final String URL = "http://localhost:8080/web/";

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
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IUserService#getUser(java.lang.String,
	 * java.lang.String)
	 */
	public User getUser(String login, String password)
	{
		LOG.info("Appel de la méthode getUser() du dao");
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);
		
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target(URL).path("rest/userService/getUser");

		String input = "{\"login\":\"" + login + "\", \"password\":\"" + password + "\"}";

		Response response = webTarget.request("application/json").post(Entity.json(input));
		
		return response.readEntity(User.class);
	}
}
