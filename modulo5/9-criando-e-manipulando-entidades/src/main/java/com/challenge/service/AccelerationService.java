package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@Service
public class AccelerationService implements AccelerationServiceInterface{
	
	private AccelerationRepository repository;
	
	@Autowired
	public AccelerationService(AccelerationRepository repository) {
		this.repository = repository;
	}

	@Override
	public Acceleration save(Acceleration object) {
		return repository.save(object);
	}

	@Override
	public Optional<Acceleration> findById(Long id) {
		return repository.findById(id);
	}


	@Override
	public List<Acceleration> findByCompanyId(Long companyId) {
		return repository.findByCompanyId(companyId);
	}

}
