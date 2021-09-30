package com.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringChallengeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(SpringChallengeApplication.class, args);
	}

}
