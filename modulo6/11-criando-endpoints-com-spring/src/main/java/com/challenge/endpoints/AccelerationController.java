package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {
	
	@Autowired
	private AccelerationService service;
	
	@GetMapping("/{id}")
	public Optional<Acceleration> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping(params = "companyId")
	public List<Acceleration> findByCompanyId(@RequestParam("companyId") Long id) {
		return service.findByCompanyId(id);
	}

}
