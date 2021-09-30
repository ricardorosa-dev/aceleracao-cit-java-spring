package com.challenge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Candidate;
import com.challenge.service.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	private CandidateService service;
	
	public CandidateController(CandidateService service) {
		this.service = service;
	}
	
	public List<Candidate> getAllCandidates() {
		return service.getAllCandidates();
	}
	
	public void saveCandidate(Candidate candidate) {
		service.saveCandidate(candidate);
	}

}
