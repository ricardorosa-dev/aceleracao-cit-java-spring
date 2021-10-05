package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	private CompanyService service;
	
	@Autowired
	public CompanyController(CompanyService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public Optional<Company> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping(params = "accelerationId")
	public List<Company> findByAccelerationId(@RequestParam Long accelerationId) {
		return service.findByAccelerationId(accelerationId);
	}
	
	@GetMapping(params = "userId")
	public List<Company> findByUserId(@RequestParam Long userId) {
		return service.findByUserId(userId);
	}

}
