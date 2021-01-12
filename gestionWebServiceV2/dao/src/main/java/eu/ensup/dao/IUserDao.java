package eu.ensup.dao;

import eu.ensup.domaine.User;

public interface IUserDao
{

	/**
	 * Retourne un utilisateur en fonction de son login et mot de masse.
	 * @param login Le login de l'utilisateur.
	 * @param password Le mot de passe de l'utilisateur.
	 * @return L'utilisateur dont le login et mot de passe correspondent.
	 */
	User getUser(String login, String password);

}