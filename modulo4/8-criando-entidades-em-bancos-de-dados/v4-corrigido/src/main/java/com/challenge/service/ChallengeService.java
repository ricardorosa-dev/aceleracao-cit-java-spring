package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;

@Service
public class ChallengeService {
	
	private final ChallengeRepository repository;
	
	@Autowired
	public ChallengeService(ChallengeRepository repository) {
		this.repository = repository;
	}
	
	public List<Challenge> getChallenges() {
		return repository.findAll();
	}
	
	public void saveChallenge(Challenge challenge) {
		repository.save(challenge);
	}
	
	public Optional<Challenge> findById(int id) {
		return repository.findById(id);
	}

}
