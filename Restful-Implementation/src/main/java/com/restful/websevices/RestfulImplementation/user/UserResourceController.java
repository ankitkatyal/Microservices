package com.restful.websevices.RestfulImplementation.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restful.websevices.RestfulImplementation.Exception.UserNotFoundException;

@RestController
public class UserResourceController {
	
	
	@Autowired
	private UserDaoService userService;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.findAll();
		
	}

	
	@GetMapping("/users/{id}")
	public User getAllUsers(@PathVariable Integer id){
		User user  =  userService.findOne(id);
		if(user ==null) {
			throw new UserNotFoundException("id = "+id);
		}
		return user;
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		User user  =  userService.deleteById(id);
		if(user ==null) {
			throw new UserNotFoundException("id = "+id);
		}
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUsers(@Valid @RequestBody User user){
		 User savedUser = userService.save(user);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		 return ResponseEntity.created(location).build();
	}
}
