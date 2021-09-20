package com.challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.Challenge;
import com.challenge.entity.Company;
import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import com.challenge.entity.User;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.ChallengeRepository;
import com.challenge.repository.CompanyRepository;
import com.challenge.repository.SubmissionRepository;
import com.challenge.repository.UserRepository;

@SpringBootApplication
@EnableJpaAuditing
public class SpringChallengeApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = 
				SpringApplication.run(SpringChallengeApplication.class, args);
		UserRepository userRepository = 
				configurableApplicationContext.getBean(UserRepository.class);
		AccelerationRepository accelerationRepository = 
				configurableApplicationContext.getBean(AccelerationRepository.class);
		ChallengeRepository challengeRepository = 
				configurableApplicationContext.getBean(ChallengeRepository.class);
		SubmissionRepository submissionRepository =
				configurableApplicationContext.getBean(SubmissionRepository.class);
		CandidateRepository candidateRepository =
				configurableApplicationContext.getBean(CandidateRepository.class);
		CompanyRepository companyRepository =
				configurableApplicationContext.getBean(CompanyRepository.class);
		
		User user = User.builder()
				.fullName("John")
				.email("john@mail.com")
				.nickname("jon")
				.password("123").build();
		userRepository.save(user);
		
		Acceleration acceleration = 
				new Acceleration("Java Spring Boot", "/codenation/java-spring");
		accelerationRepository.save(acceleration);
		Acceleration acceleration2 = 
				new Acceleration("Java Spring Not Boot", "/codenation/java-spring2");
		accelerationRepository.save(acceleration2);
		
		List<Acceleration> myAccelerations = new ArrayList<>();
		myAccelerations.add(acceleration);
		myAccelerations.add(acceleration2);
		
//		Challenge challenge = new Challenge(1, "Entity Relationship", "/entity-rel", myAccelerations, null);
		Challenge challenge1 = Challenge.builder()
				.name("Ent-Rel")
				.slug("/entrel")
				.accelerations(myAccelerations).build();
		challengeRepository.save(challenge1);
//		Challenge challenge = new Challenge(2, "Julio Cesar", "julio-cesar", myAccelerations, null);
		Challenge challenge2 = Challenge.builder()
				.name("Julio Cesar")
				.slug("/jcesar")
				.accelerations(myAccelerations).build();
		challengeRepository.save(challenge2);
		
//		challenge2.addUser(user);
//		user.addChallenge(challenge2);
		
		Acceleration acceleration3 = 
				new Acceleration("Aceleracao 2", "/a2");
		accelerationRepository.save(acceleration3);
		
		User user3 = User.builder()
				.fullName("bob change")
				.email("bob@mailcom")
				.nickname("bob")
				.password("12334").build();
		
//		User user4 = User.builder()
//				.fullName("Josh Bobbers")
//				.email("josh@mail.com")
//				.nickname("jo")
//				.password("111111").build();
		
		Acceleration accel1 = new Acceleration("Java", "/java");
		accel1.setChallengeId(challenge2);
		accelerationRepository.save(accel1);
		
		Company company1 = new Company("CI&T", "/ciandt");
		companyRepository.save(company1);
		
		Candidate candidate1 = new Candidate(user3, accel1, company1, 3);
		candidate1.setCompany(company1);
		candidateRepository.save(candidate1);
		
//		user3.addCandidate(candidate1);
//		Submission mySub = new Submission(user3, challenge2, 25);
//		submissionRepository.save(mySub);
//		user3.addSubmission(mySub);
		
		accel1.addCandidate(candidate1);
		
//		userRepository.save(user3);
		
		System.out.println(user3.getCandidate());
		
		
		
		
//		Submission user1sub1 = Submission.builder()
//				.userId(user)
//				.challengeId(challenge2)
//				.score(1).build();
	}

//	public static void main(String[] args) {
//		SpringApplication.run(SpringChallengeApplication.class, args);
//	}

}
