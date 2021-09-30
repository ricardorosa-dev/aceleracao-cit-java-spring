package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import com.challenge.repository.SubmissionRepository;

@Service
public class SubmissionService {
	
	private final SubmissionRepository repository;
	
	@Autowired
	public SubmissionService(SubmissionRepository repository) {
		this.repository = repository;
	}
	
	public List<Submission> getSubmissions() {
		return repository.findAll();
	}
	
	public void saveSubmission(Submission submission) {
		repository.save(submission);
	}
	
	public Optional<Submission> findById(SubmissionId id) {
		return repository.findById(id);
	}

}
