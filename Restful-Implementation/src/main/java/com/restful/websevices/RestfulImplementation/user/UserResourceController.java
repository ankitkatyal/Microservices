package com.restful.websevices.RestfulImplementation.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResourceController {
	
	
	@Autowired
	private UserDaoService userService;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.findAll();
		
	}

	
	@GetMapping("/user/{id}")
	public User getAllUsers(@PathVariable Integer id){
		return userService.getUser(id);
		
	}
}
