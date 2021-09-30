package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;

@Service
public class AccelerationService {
	
	private final AccelerationRepository repository;
	
	@Autowired
	public AccelerationService(AccelerationRepository repository) {
		this.repository = repository;
	}
	
	public List<Acceleration> getAccelerations() {
		return repository.findAll();
	}
	
	public void saveAcceleration(Acceleration acceleration) {
		repository.save(acceleration);
	}

}
