package eu.ensup.partiel_spring.service;

import java.util.List;

import eu.ensup.partiel_spring.entities.User;

public interface IUserService {

	List<User> getAllusers();

	User getUserById(Long id);

	void createUser(User user);

	void updateUser(User userFound);

	User getUser(User user);

}