package com.mosypka.pgsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner init(UserRepository userRepository, ActivityRepository activityRepository){
////		return (args) -> {
////			Arrays.asList("user1","user2","user3","user4","user5","user6").forEach(
////					u -> {
////						User user = userRepository.save(new User(u,"us", "er","okon","123456789",u +"@gmail.com", Role.USER));
////						activityRepository.save(new Activity("Activity 1",new Date(),user));
////						activityRepository.save(new Activity("Activity 2",new Date(),user));
////						activityRepository.save(new Activity("Activity 3",new Date(),user));
////					}
////			);
////		};
//	}
}
