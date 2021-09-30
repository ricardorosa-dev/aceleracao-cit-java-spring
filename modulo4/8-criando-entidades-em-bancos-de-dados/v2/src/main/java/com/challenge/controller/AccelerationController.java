package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.AccelerationService;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {
	
	private AccelerationService service;
	
	@Autowired
	public AccelerationController(AccelerationService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Acceleration> getAccelerations() {
		return service.getAccelerations();
	}
	
	@PostMapping
	public void saveAcceleration(@RequestBody Acceleration acceleration) {
		service.saveAcceleration(acceleration);
	}

}
