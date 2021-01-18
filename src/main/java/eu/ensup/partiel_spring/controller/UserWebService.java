package eu.ensup.partiel_spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.partiel_spring.entities.User;
import eu.ensup.partiel_spring.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserWebService {

	@Autowired
	private IUserService userService;
	
	
	
	public UserWebService(IUserService userService) {
		this.userService = userService;
	}



	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return userService.getAllusers();
	}
	
	@GetMapping("/detail/{id}")
	public User getUserById(@PathVariable(value = "id") Long id){
		return userService.getUserById(id);
	}
	
	@PostMapping("/getUser")
	public Map<String, User> getUser(@Validated @RequestBody User user) {
		 Map<String,User> map = new HashMap<String, User>();
         User u = userService.getUser(user);
         String message = "user";

         map.put(message,u);


         return map;
	}
	
	@PostMapping("/create")
	public void createUser(@Validated @RequestBody User user) {
		userService.createUser(user);
	}
	
	@PutMapping("/update/{id}")
	public void updateUser(@PathVariable (value = "id") Long id, @RequestBody User user) {
		
		User userFound = userService.getUserById(id);
		userFound.setId(user.getId());
		userService.updateUser(userFound);
	}
}
