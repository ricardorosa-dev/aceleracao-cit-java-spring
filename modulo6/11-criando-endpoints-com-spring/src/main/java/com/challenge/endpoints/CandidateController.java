package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	private CandidateService service;
	
	public CandidateController(CandidateService service) {
		this.service = service;
	}
	
	@GetMapping("/{userId}/{accelerationId}/{companyId}")
	public Optional<Candidate> findById(
			@PathVariable("userId") Long userId, 
			@PathVariable("companyId") Long companyId, 
			@PathVariable("accelerationId") Long accelerationId
	) {
		return service.findById(userId, companyId, accelerationId);
	}
	
	@GetMapping(params = "companyId")
	public List<Candidate> findByCompanyId(@RequestParam Long companyId) {
		return service.findByCompanyId(companyId);
	}
	
	@GetMapping(params = "accelerationId")
	public List<Candidate> findByAccelerationId(@RequestParam Long accelerationId) {
		return service.findByAccelerationId(accelerationId);
	}

}
