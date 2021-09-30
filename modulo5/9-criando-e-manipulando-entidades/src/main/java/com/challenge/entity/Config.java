package com.challenge.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.ChallengeRepository;
import com.challenge.repository.CompanyRepository;
import com.challenge.repository.SubmissionRepository;
import com.challenge.repository.UserRepository;

@Component
public class Config implements CommandLineRunner{
	
	private UserRepository userRepository;
	private AccelerationRepository accelerationRepository;
	private CandidateRepository candidateRepository;
	private ChallengeRepository challengeRepository;
	private CompanyRepository companyRepository;
	private SubmissionRepository submissionRepository;
	
	public Config(
			UserRepository userRepository,
			AccelerationRepository accelerationRepository,
			CandidateRepository candidateRepository,
			ChallengeRepository challengeRepository,
			CompanyRepository companyRepository,
			SubmissionRepository submissionRepository
	) {
		this.userRepository = userRepository;
		this.accelerationRepository = accelerationRepository;
		this.candidateRepository = candidateRepository;
		this.challengeRepository = challengeRepository;
		this.companyRepository = companyRepository;
		this.submissionRepository = submissionRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		LocalDateTime now = LocalDateTime.now();
		User user1 = new User("josiah bobbers", "josiah@email.com", "jo", "123456", now);
		userRepository.save(user1);
		User user2 = new User("jennifer system", "jen@email.com", "jen", "12345678", now);
		userRepository.save(user2);
		
		Challenge challenge1 = new Challenge("JPQL Queries", "/queries", now);
		Challenge challenge2 = new Challenge("Julio Cesar", "/jcesar", now);
		Challenge challenge3 = new Challenge("Entender o conteudo", "/conteudo", now);
		challengeRepository.save(challenge1);
		challengeRepository.save(challenge2);
		challengeRepository.save(challenge3);
		
		Acceleration acceleration1 = new Acceleration("Java", "/java", challenge1, now);
		Acceleration acceleration2 = new Acceleration("Node", "/node", challenge2, now);
		Acceleration acceleration3 = new Acceleration("React", "/react", challenge3, now);
		accelerationRepository.save(acceleration1);
		accelerationRepository.save(acceleration2);
		accelerationRepository.save(acceleration3);
		
		Company company1 = new Company("CI&T", "/ciandt", now);
		companyRepository.save(company1);
		
		CandidateId cId1 = new CandidateId(user1, acceleration1, company1);
		Candidate candidate1 = new Candidate(cId1, 2, now);
		CandidateId cId2 = new CandidateId(user1, acceleration2, company1);
		Candidate candidate2 = new Candidate(cId2, 2, now);
		CandidateId cId3 = new CandidateId(user1, acceleration3, company1);
		Candidate candidate3 = new Candidate(cId3, 5, now);
		candidateRepository.save(candidate1);
		candidateRepository.save(candidate2);
		candidateRepository.save(candidate3);
		
		SubmissionId sId1 = new SubmissionId(challenge1, user1);
		Submission submission1 = new Submission(sId1, 7F, now);
		submissionRepository.save(submission1);
		SubmissionId sId2 = new SubmissionId(challenge1, user2);
		Submission submission2 = new Submission(sId2, 4F, now);
		submissionRepository.save(submission2);
		SubmissionId sId3 = new SubmissionId(challenge2, user1);
		Submission submission3 = new Submission(sId3, 9F, now);
		submissionRepository.save(submission3);
		SubmissionId sId4 = new SubmissionId(challenge2, user2);
		Submission submission4 = new Submission(sId4, 8F, now);
		submissionRepository.save(submission4);
		
//		List<User> usersInAcceleration = userRepository.findByAccelerationName("Java");
//		System.out.println(usersInAcceleration);
		
//		List<Acceleration> accelByComId = accelerationRepository.findByCompanyId(1L);
//		
//		for(Acceleration accel : accelByComId) {
//			System.out.println(accel.getName());
//		}
		
//		List<Challenge> challengesByAccId = challengeRepository.findByUserId(1L);
//		
//		for(Challenge chall : challengesByAccId) {
//			System.out.println(chall.getName());
//		}
		
//		List<Challenge> byAccelAndUser = 
//				challengeRepository.findByAccelerationIdAndUserId(2L, 1L);
//		
//		for(Challenge chall : byAccelAndUser) {
//			System.out.println(chall.getName());
//		}
		
//		List<Company> companyByUser = 
//				companyRepository.findByAccelerationId(1L);
//		
//		for(Company comp : companyByUser) {
//			System.out.println(comp.getName());
//		}
		
//		BigDecimal scoreByChId = 
//				submissionRepository.findHigherScoreByChallengeId(1L);
//		
//		System.out.println(scoreByChId);
		
//		for(Submission sub : scoreByChId) {
//			System.out.println(sub.getScore());
//		}
		
//		Optional<Candidate> candById = 
//				candidateRepository.findById(1L, 2L, 3L);
//		
//		System.out.println(candById);
		
	}

}
