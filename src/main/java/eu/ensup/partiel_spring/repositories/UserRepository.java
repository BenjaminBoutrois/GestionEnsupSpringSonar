package eu.ensup.partiel_spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.partiel_spring.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByLoginAndPassword(String login, String password);

}
