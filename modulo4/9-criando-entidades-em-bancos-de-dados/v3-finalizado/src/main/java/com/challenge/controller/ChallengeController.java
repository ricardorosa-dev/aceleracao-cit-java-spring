package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.ChallengeService;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
	
	private final ChallengeService service;
	
	@Autowired
	public ChallengeController(ChallengeService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Challenge> getChallenges() {
		return service.getChallenges();
	}
	
	@PostMapping
	public void saveChallenge(@RequestBody Challenge challenge) {
		service.saveChallenge(challenge);
	}

}
