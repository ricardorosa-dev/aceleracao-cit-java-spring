package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.entity.Company;
import com.challenge.repository.ChallengeRepository;
import com.challenge.repository.CompanyRepository;

@Service
public class CompanyService {
	
private final CompanyRepository repository;
	
	@Autowired
	public CompanyService(CompanyRepository repository) {
		this.repository = repository;
	}
	
	public List<Company> getCompanies() {
		return repository.findAll();
	}
	
	public void saveCompany(Company company) {
		repository.save(company);
	}
	
	public Optional<Company> findById(int id) {
		return repository.findById(id);
	}

}
