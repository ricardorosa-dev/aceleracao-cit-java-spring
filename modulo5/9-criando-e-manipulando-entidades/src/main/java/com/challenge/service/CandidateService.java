package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;

@Service
public class CandidateService implements CandidateServiceInterface{
	
	private CandidateRepository repository;
	
	@Autowired
	public CandidateService(CandidateRepository repository) {
		this.repository = repository;
	}

	@Override
	public Candidate save(Candidate object) {
		return repository.save(object);
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		return repository.findById(userId, companyId, accelerationId);
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		return repository.findByCompanyId(companyId);
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		return repository.findByAccelerationId(accelerationId);
	}

}
