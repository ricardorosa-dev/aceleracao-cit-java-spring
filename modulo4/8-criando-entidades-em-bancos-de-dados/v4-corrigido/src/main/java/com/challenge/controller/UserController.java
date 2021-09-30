package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@PostMapping
	public void saveUser(@RequestBody User user) {
		service.saveUser(user);
	}

}
