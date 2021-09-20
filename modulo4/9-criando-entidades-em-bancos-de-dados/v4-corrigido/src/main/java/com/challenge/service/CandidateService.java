package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Candidate;
import com.challenge.repository.CandidateRepository;

@Service
public class CandidateService {
	
	private CandidateRepository repository;
	
	@Autowired
	public CandidateService(CandidateRepository repository) {
		this.repository = repository;
	}
	
	public List<Candidate> getAllCandidates() {
		return repository.findAll();
	}
	
	public void saveCandidate(Candidate candidate) {
		repository.save(candidate);
	}
}
