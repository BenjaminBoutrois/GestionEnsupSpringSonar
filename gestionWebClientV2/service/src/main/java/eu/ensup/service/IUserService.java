package eu.ensup.service;

import eu.ensup.domaine.User;

public interface IUserService
{

	/**
	 * Retourne un utilisateur en fonction de son login et son mot de passe.
	 * @param login Le login de l'utilisateur à chercher.
	 * @param password Le mot de passe de l'utilisateur à chercher.
	 * @return L'utilisateur correspondant au login et mot de passe.
	 */
	User getUser(String login, String password);

}