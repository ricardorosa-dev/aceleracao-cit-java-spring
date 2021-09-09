package com.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;

@SpringBootApplication
public class SpringChallengeApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = 
				SpringApplication.run(SpringChallengeApplication.class, args);
		UserRepository userRepository = 
				configurableApplicationContext.getBean(UserRepository.class);
		
		User user = new User(0, "josiah banks", "josiah@mail.com", "jo", "123456");
		userRepository.save(user);
		
	}

//	public static void main(String[] args) {
//		SpringApplication.run(SpringChallengeApplication.class, args);
//	}

}
