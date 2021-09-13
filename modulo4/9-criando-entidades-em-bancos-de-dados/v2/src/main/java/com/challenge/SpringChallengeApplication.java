package com.challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Challenge;
import com.challenge.entity.Submission;
import com.challenge.entity.User;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.ChallengeRepository;
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
		
		User user = User.builder().fullName("John").email("john@mail.com").nickname("jon").password("123").build();
		
		userRepository.save(user);
		
		Acceleration acceleration = 
				new Acceleration(1, "Java Spring Boot", "/codenation/java-spring", null);
		accelerationRepository.save(acceleration);
		Acceleration acceleration2 = 
				new Acceleration(2, "Java Spring Not Boot", "/codenation/java-spring2", null);
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
		
		Acceleration acceleration3 = 
				new Acceleration(2, "Aceleracao 2", "/a2", challenge1);
		accelerationRepository.save(acceleration3);
		
		
		
//		Submission user1sub1 = Submission.builder()
//				.userId(user)
//				.challengeId(challenge2)
//				.score(1).build();
	}

//	public static void main(String[] args) {
//		SpringApplication.run(SpringChallengeApplication.class, args);
//	}

}
