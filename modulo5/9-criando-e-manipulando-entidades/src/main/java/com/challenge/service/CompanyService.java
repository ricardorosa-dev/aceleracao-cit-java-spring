package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

@Service
public class CompanyService implements CompanyServiceInterface{
	
	private CompanyRepository repository;
	
	public CompanyService(CompanyRepository repository) {
		this.repository = repository;
	}

	@Override
	public Company save(Company object) {
		return repository.save(object);
	}

	@Override
	public Optional<Company> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Company> findByAccelerationId(Long accelerationId) {
		return repository.findByAccelerationId(accelerationId);
	}

	@Override
	public List<Company> findByUserId(Long userId) {
		return repository.findByUserId(userId);
	}
	

}
