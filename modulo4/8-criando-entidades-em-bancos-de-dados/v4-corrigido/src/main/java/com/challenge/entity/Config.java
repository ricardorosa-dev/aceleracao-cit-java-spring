package com.challenge.entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.ChallengeRepository;
import com.challenge.repository.CompanyRepository;
import com.challenge.repository.UserRepository;

@Component
public class Config implements CommandLineRunner{
	
	private AccelerationRepository accelerationRepository;
	private ChallengeRepository challengeRepository;
	private CompanyRepository companyRepository;
	private UserRepository userRepository;
	
	public Config(
			AccelerationRepository accelerationRepository,
			ChallengeRepository challengeRepository,
			CompanyRepository companyRepository,
			UserRepository userRepository
	) {
		this.accelerationRepository = accelerationRepository;
		this.challengeRepository = challengeRepository;
		this.companyRepository = companyRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Challenge challenge1 = new Challenge("challenge1", "/chall1");
		challengeRepository.save(challenge1);
		
		Acceleration acceleration1 = new Acceleration("Java", "/java1");
		acceleration1.setChallengeId(challenge1);
		accelerationRepository.save(acceleration1);
		
		User user1 = new User("josias bernard", "josias@mail.com", "jo", "12345");
		userRepository.save(user1);
		
		Company company1 = new Company("CI&T", "/ciandt");
		companyRepository.save(company1);
		
		
	}

}
