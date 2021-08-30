package com.challenge.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.challenge.repository.UserRepository;

public class UserTest {
	
	UserRepository userRepository;

	@Test
	public void TestIfUserIsCreatedCorrectly() {
		User user1 = User.builder()
				.fullName("Joao de Matos")
				.email("jmatos@gmail.com")
				.nickname("jmatos")
				.password("matos4567")
				.build();
		
		User user2 = User.builder()
				.fullName("Mario Lacerda")
				.email("mlacerda@gmail.com")
				.nickname("mlacerda")
				.password("lac8978")
				.build();
		
//		userRepository.save(user1);
		
		System.out.println(user1);
		System.out.println(user2);
	}

}
