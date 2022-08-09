package com.noovi2.userdept.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.noovi2.userdept.entities.User;
import com.noovi2.userdept.repositories.UserRepository;

@Configuration
@Profile ("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User (null,"Maria Joaquina","Maria@gmail.com","911111111","123456");
		User u2 = new User (null, "Felipe Correa", "felipe@yahoo.com","92222222","78945613");
		
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
	}
	
	
	
}
