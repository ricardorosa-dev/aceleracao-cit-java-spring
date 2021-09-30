package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service
public class SubmissionService implements SubmissionServiceInterface{
	
	private SubmissionRepository repository;
	
	@Autowired
	public SubmissionService(SubmissionRepository repository) {
		this.repository = repository;
	}

	@Override
	public Submission save(Submission object) {
		return repository.save(object);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		BigDecimal score = repository.findHigherScoreByChallengeId(challengeId);
		
		if(score == null) {
			return new BigDecimal(0.0);
		}
		return score;
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}

}
