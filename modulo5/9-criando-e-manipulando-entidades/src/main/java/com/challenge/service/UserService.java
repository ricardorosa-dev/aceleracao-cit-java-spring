package com.challenge.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{
	
	private UserRepository repository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	@NotNull
	public User save(User object) {
		return repository.save(object);
		
	}

	@Override
	public Optional<User> findById(Long userId) {
		return repository.findById(userId);
	}

	@Override
	public List<User> findByAccelerationName(String name) {
		return repository.findByAccelerationName(name); 
	}

	@Override
	public List<User> findByCompanyId(Long companyId) {
		return repository.findByCompanyId(companyId);
	}

}
