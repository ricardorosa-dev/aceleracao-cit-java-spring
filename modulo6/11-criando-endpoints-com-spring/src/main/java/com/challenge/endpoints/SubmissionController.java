package com.challenge.endpoints;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
	
	private SubmissionService service;
	
	@Autowired
	public SubmissionController(SubmissionService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Submission> findByChallengeIdAndAccelerationId(
			@RequestParam(value = "challengeId") Long challengeId,
			@RequestParam(value = "accelerationId") Long accelerationId
	) {
		
		return service.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}

}
