package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.challenge.entity.Challenge;
import com.challenge.entity.User;
import com.challenge.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> getUsers() {
		return repository.findAll();
	}

//	public ResponseEntity<User> saveUser(User user) {
//		return ResponseEntity.ok(repository.save(user));
//	}
	
	public void saveUser(User user) {
		User newUser = new User();
		newUser.setFullName(user.getFullName());
//		newUser.setSubmissions(user.getSubmissions());
		repository.save(user);
	}

}
