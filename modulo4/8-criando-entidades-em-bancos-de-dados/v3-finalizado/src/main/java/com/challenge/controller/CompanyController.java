package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.entity.Company;
import com.challenge.service.ChallengeService;
import com.challenge.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	private final CompanyService service;
	
	@Autowired
	public CompanyController(CompanyService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Company> getCompany() {
		return service.getCompanies();
	}
	
	@PostMapping
	public void saveCompany(@RequestBody Company company) {
		service.saveCompany(company);
	}

}
