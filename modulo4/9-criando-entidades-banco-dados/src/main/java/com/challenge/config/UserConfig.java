//package com.challenge.config;
//
//import java.util.List;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.challenge.entity.User;
//import com.challenge.repository.UserRepository;
//
//@Configuration
//public class UserConfig {
//	
//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository userRepository) {
//		return args -> {
//			User user1 = User.builder()
//					.fullName("Joao de Matos")
//					.email("jmatos@gmail.com")
//					.nickname("jmatos")
//					.password("matos4567")
//					.build();
//			
//			User user2 = User.builder()
//					.fullName("Mario Lacerda")
//					.email("mlacerda@gmail.com")
//					.nickname("mlacerda")
//					.password("lac8978")
//					.build();
//			
////			userRepository.saveAll(List.of(user1, user2));
//			
//			System.out.println(user1);
//					
//		};
//	}
//}
