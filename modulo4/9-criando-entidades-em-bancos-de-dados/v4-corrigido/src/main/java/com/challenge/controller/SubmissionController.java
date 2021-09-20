package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Submission;
import com.challenge.service.SubmissionService;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
	
	private final SubmissionService service;
	
	@Autowired
	public SubmissionController(SubmissionService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Submission> getSubmissions() {
		return service.getSubmissions();
	}
	
	@PostMapping
	public void saveSubmissions(Submission submission) {
		service.saveSubmission(submission);
	}

}
