package eu.ensup.partiel_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.partiel_spring.entities.User;
import eu.ensup.partiel_spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	
	@Override
	public List<User> getAllusers(){
		return (List<User>) userRepo.findAll();
	}

	
	@Override
	public User getUserById(Long id) {		
		return userRepo.findById(id).get();
	}
	
	@Override
	public User getUser(User user) {
		return userRepo.findByLoginAndPassword(user.getLogin(), user.getPassword());
	}


	@Override
	public void createUser(User user) {		
		userRepo.save(user);
	}


	@Override
	public void updateUser(User userFound) {
		userRepo.save(userFound);
	}

}
